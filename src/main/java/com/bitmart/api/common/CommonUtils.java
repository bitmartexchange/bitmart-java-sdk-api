package com.bitmart.api.common;

import com.bitmart.api.annotations.ParamKey;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class CommonUtils {
    private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);


    public CommonUtils() {
    }

    public static Map<String, Object> genRequestMap(Object cloudRequest) throws CloudException {
        if(cloudRequest == null) {
            return new TreeMap<>();
        }
        Map<String, Object> paraMap = new TreeMap<>();

        try {
            Field[] declaredFields = cloudRequest.getClass().getDeclaredFields();
            if (declaredFields.length == 0) {
                return new TreeMap<>();
            }

            List<Field> collect = Arrays.stream(declaredFields).collect(Collectors.toList());

            // FIXED: remove the following code
            // Field[] declaredFields1 = cloudRequest.getClass().getSuperclass().getDeclaredFields();
            // collect.addAll(Arrays.stream(declaredFields1).collect(Collectors.toList()));

            for (Field declaredField : collect) {
                declaredField.setAccessible(true);

                final ParamKey paramKey = declaredField.getAnnotation(ParamKey.class);

                if (paramKey != null) {
                    String key = paramKey.value();
                    Object value = declaredField.get(cloudRequest);
                    if(paramKey.required() && value == null) {
                        throw new CloudException("The request parameter [" + declaredField.getName() + "] is required");
                    }

                    if(value != null) {
                        paraMap.put(key, value);
                    }

                }

            }
        } catch (Exception ex) {
            throw new CloudException(ex.getMessage());
        }
        return paraMap;
    }


    public static int getRateLimitValue(String val) {
        try {
            return Integer.parseInt(StringUtils.defaultIfBlank(val, "0"));
        } catch (Exception e) {
            log.warn("getRateLimitValue value={}",  val);
        }
        return 0;
    }
}
