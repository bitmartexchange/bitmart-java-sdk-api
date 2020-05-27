package com.bitmart.api;

import com.bitmart.api.common.CloudException;
import com.bitmart.api.common.CommonUtils;
import com.bitmart.api.common.GlobalConst;
import com.bitmart.api.common.JsonUtils;
import com.bitmart.api.key.CloudSignature;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class Call {
    private final CloudContext cloudContext;
    private static OkHttpClient okHttpClient = defaultOkHttpClient();

    private static OkHttpClient defaultOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)  // debug
                .build();
    }

    public Call(CloudContext cloudContext) {
        this.cloudContext = cloudContext;
    }

    public String callCloud(CloudRequest cloudRequest) throws CloudException {
        return Method.POST.equals(cloudRequest.getMethod()) ? POST(cloudRequest) : GET(cloudRequest);
    }

    private String POST(CloudRequest cloudRequest) throws CloudException {
        if (cloudRequest == null) {
            throw new CloudException("request can not null");
        } else {
            Map<String, String> paraMap = CommonUtils.genRequestMap(cloudRequest);

            String json = JsonUtils.toJson(cloudRequest);
            RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);

            Headers header = setHeaders(cloudRequest, json);
            Request request = (new okhttp3.Request.Builder()).url(this.cloudContext.getCloudUrl() + cloudRequest.getPath())
                    .headers(header)
                    .post(requestBody).build();
            okhttp3.Call okCall = okHttpClient.newCall(request);

            return getResponse(paraMap, okCall);
        }
    }


    private String GET(CloudRequest cloudRequest) throws CloudException {
        if (cloudRequest == null) {
            throw new CloudException("request can not null");
        } else {

            StringJoiner url = new StringJoiner("");
            Map<String, String> paraMap = CommonUtils.genRequestMap(cloudRequest);
            url.add(this.cloudContext.getCloudUrl() + cloudRequest.getPath());
            if (!paraMap.isEmpty()) {
                url.add("?");
            }

            String queryString = getQueryString(paraMap);
            Headers header = setHeaders(cloudRequest, queryString);
            Request request = (new okhttp3.Request.Builder()).url(url.toString() + queryString)
                    .headers(header)
                    .get().build();
            okhttp3.Call okCall = okHttpClient.newCall(request);

            return getResponse(paraMap, okCall);
        }
    }

    private String getQueryString(Map<String, String> paraMap){
        StringJoiner fromData = new StringJoiner("");
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            fromData.add(entry.getKey()).add("=").add(entry.getValue()).add("&");
        }

        String queryString = fromData.toString();
        if (queryString.endsWith("&")) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }


        System.out.println("queryString:" + queryString);

        return queryString;
    }

    private Headers setHeaders(CloudRequest cloudRequest, String queryString) throws CloudException {
        Headers header = Headers.of();
        if (Auth.KEYED == cloudRequest.getAuth() || Auth.SIGNED == cloudRequest.getAuth()) {
            CloudSignature.Signature signature = CloudSignature.create(queryString, this.cloudContext.getCloudKey().getApiSecret(), this.cloudContext.getCloudKey().getMemo());
            header = Headers.of(
                    GlobalConst.X_BM_KEY, this.cloudContext.getCloudKey().getApiKey(),
                    GlobalConst.X_BM_TIMESTAMP, signature.getTimestamp(),
                    GlobalConst.X_BM_SIGN, signature.getSign()
            );
        }
        return header;
    }

    private String getResponse(Map<String, String> paraMap, okhttp3.Call okCall) throws CloudException {
        try {
            Response response = okCall.execute();
            if (response.isSuccessful()) {
                String body = response.body().string();
                Map<String, Object> jsonMap = JsonUtils.toMap(body);
                Object message = jsonMap.get("message");
                if (message != null && !"OK".equals(message.toString())) {
                    throw new CloudException(body);
                }

                return body;
            } else {
                throw new CloudException(
                        String.format("request cloud exception [code=[%d],message=[%s]", response.code(), response.body().string()));
            }

        } catch (IOException var18) {
            log.warn("request cloud error," + paraMap + ", error=" + var18.getMessage());
        }

        throw new CloudException("request cloud exception");
    }


}
