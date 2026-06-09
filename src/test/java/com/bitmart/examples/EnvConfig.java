package com.bitmart.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Lightweight loader for a project-local {@code .env} file (test scope only).
 *
 * <p>Resolution priority for a key is: <b>.env file &gt; system environment variable &gt; provided default</b>.
 *
 * <p>The {@code .env} file lives at the project root and is git-ignored, so real credentials never
 * get committed. Locating it does NOT depend on the JVM working directory (so it works no matter how
 * the IDE/Maven/Zed launches the program); it is searched in this order:
 * <ol>
 *   <li>explicit path from system property {@code bitmart.env.file} or env var {@code BITMART_ENV_FILE};</li>
 *   <li>walking up from the working directory ({@code user.dir}) through parent directories;</li>
 *   <li>walking up from this class' code-source location (e.g. {@code target/test-classes}).</li>
 * </ol>
 *
 * <p>Lines are parsed as {@code KEY=VALUE}; blank lines and lines starting with {@code #} are ignored,
 * and surrounding single/double quotes around the value are stripped.
 */
public final class EnvConfig {

    private static final Map<String, String> ENV = load();

    private EnvConfig() {
    }

    private static Map<String, String> load() {
        Map<String, String> map = new HashMap<>();
        File file = locate();
        if (file == null) {
            System.out.println("[EnvConfig] No .env found (searched override / "
                    + "user.dir=" + System.getProperty("user.dir") + " and parents / code-source); "
                    + "falling back to environment variables and defaults.");
            return map;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                int idx = line.indexOf('=');
                if (idx <= 0) {
                    continue;
                }
                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();
                if (value.length() >= 2
                        && ((value.startsWith("\"") && value.endsWith("\""))
                        || (value.startsWith("'") && value.endsWith("'")))) {
                    value = value.substring(1, value.length() - 1);
                }
                map.put(key, value);
            }
        } catch (Exception e) {
            // ignore: fall back to environment variables / defaults
        }
        return map;
    }

    /**
     * Locate the {@code .env} file independently of the working directory. Returns null if not found.
     */
    private static File locate() {
        // 1) explicit override
        String override = System.getProperty("bitmart.env.file");
        if (override == null || override.isEmpty()) {
            override = System.getenv("BITMART_ENV_FILE");
        }
        if (override != null && !override.isEmpty()) {
            File f = new File(override);
            if (f.isFile()) {
                return f;
            }
        }

        // 2) walk up from the working directory
        String userDir = System.getProperty("user.dir");
        if (userDir != null) {
            File found = searchUp(new File(userDir));
            if (found != null) {
                return found;
            }
        }

        // 3) walk up from this class' code-source location (independent of cwd)
        try {
            File codeSource = new File(
                    EnvConfig.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File start = codeSource.isFile() ? codeSource.getParentFile() : codeSource;
            File found = searchUp(start);
            if (found != null) {
                return found;
            }
        } catch (Exception ignored) {
            // code source not resolvable (e.g. running from a fat jar) — skip
        }

        return null;
    }

    /**
     * Walk {@code dir} and its ancestors looking for a {@code .env} file. Bounded to avoid loops.
     */
    private static File searchUp(File dir) {
        File current = dir;
        for (int depth = 0; current != null && depth < 100; depth++) {
            File candidate = new File(current, ".env");
            if (candidate.isFile()) {
                return candidate;
            }
            current = current.getParentFile();
        }
        return null;
    }

    /**
     * Resolve a configuration value.
     *
     * @param key          the configuration key (e.g. {@code BITMART_API_KEY})
     * @param defaultValue value returned when the key is absent from both the .env file and env vars
     * @return the resolved value, never null unless {@code defaultValue} is null
     */
    public static String get(String key, String defaultValue) {
        String v = ENV.get(key);              // .env file first
        if (v != null && !v.isEmpty()) {
            return v;
        }
        v = System.getenv(key);               // then system environment variable
        if (v != null && !v.isEmpty()) {
            return v;
        }
        return defaultValue;                  // then default
    }
}
