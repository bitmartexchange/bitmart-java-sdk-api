package com.bitmart.api.key;

import com.bitmart.api.common.CloudException;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public final class CloudSignature {

    public CloudSignature() {
    }

    static final String HMAC_SHA256 = "HmacSHA256";
    static String createSha256Signature(String key, String paraMap) {
        try {
            Mac sha256 = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA256);
            sha256.init(secretKeySpec);
            return Hex.encodeHexString(sha256.doFinal(paraMap.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

    public static Signature create(String queryString, String apiSecret, String apiMemo) throws CloudException {

        try {
            String timestamp = String.valueOf(System.currentTimeMillis());
            return new Signature()
                    .setTimestamp(timestamp)
                    .setSign(createSha256Signature(apiSecret,
                            String.format("%s#%s#%s", timestamp, apiMemo, queryString)));
        } catch (Exception e) {
            log.info("create sign error", e);

        }

        throw new CloudException("create signature failed");
    }


    @Data
    @Accessors(chain = true)
    public static class Signature {
        private String timestamp;
        private String sign;
    }

}
