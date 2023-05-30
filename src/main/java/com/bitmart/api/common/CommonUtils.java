package com.bitmart.api.common;

import com.bitmart.api.annotations.ParamKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class CommonUtils {
    public CommonUtils() {
    }

    public static Map<String, String> genRequestMap(Object cloudRequest) {
        if(cloudRequest == null) {
            return new TreeMap<>();
        }
        Map<String, String> paraMap = new TreeMap<>();

        try {
            Field[] declaredFields = cloudRequest.getClass().getDeclaredFields();
            Field[] declaredFields1 = cloudRequest.getClass().getSuperclass().getDeclaredFields();
            List<Field> collect = Arrays.stream(declaredFields).collect(Collectors.toList());
            collect.addAll(Arrays.stream(declaredFields1).collect(Collectors.toList()));

            for (Field declaredField : collect) {
                declaredField.setAccessible(true);

                Object paraValue = declaredField.get(cloudRequest);

                if (paraValue != null) {
                    Annotation[] annotations = declaredField.getAnnotations();
                    if (annotations != null) {
                        Annotation[] var9 = annotations;
                        int var10 = annotations.length;

                        for (int var11 = 0; var11 < var10; ++var11) {
                            Annotation annotation = var9[var11];
                            if (annotation instanceof ParamKey) {
                                String paramKey = ((ParamKey) annotation).value();
                                paraMap.put(paramKey, String.valueOf(paraValue));
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return paraMap;
    }

}
