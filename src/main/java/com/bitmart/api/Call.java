package com.bitmart.api;

import com.bitmart.api.common.*;
import com.bitmart.api.key.CloudSignature;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public final class Call {
    private static final Logger log = LoggerFactory.getLogger(Call.class);

    private final CloudContext cloudContext;
    private static final OkHttpClient okHttpClient = defaultOkHttpClient();
    private static final String USER_AGENT = "BitMart-Java-SDK-API/1.0.0";

    private static OkHttpClient defaultOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //  .addInterceptor(interceptor)  // debug
                .build();
    }

    public Call(CloudContext cloudContext) {
        this.cloudContext = cloudContext;
    }

    public CloudResponse callCloud(CloudRequest cloudRequest) throws CloudException {
        return Method.POST.equals(cloudRequest.getMethod()) ? post(cloudRequest) : get(cloudRequest);
    }

    private CloudResponse post(CloudRequest cloudRequest) throws CloudException {
        if (cloudRequest == null) {
            throw new CloudException("request can not null");
        } else {

            Map<String, String> paraMap = CommonUtils.genRequestMap(cloudRequest);

            String json = JsonUtils.toJson(paraMap);
            MediaType parse = MediaType.Companion.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.Companion.create(json, parse);

            Headers header = setHeaders(cloudRequest, json);
            Request request = (new okhttp3.Request.Builder()).url(this.cloudContext.getCloudUrl() + cloudRequest.getPath())
                    .headers(header)
                    .post(requestBody).build();
            okhttp3.Call okCall = okHttpClient.newCall(request);

            return getResponse(paraMap, okCall);
        }
    }


    private CloudResponse get(CloudRequest cloudRequest) throws CloudException {
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

        return queryString;
    }

    private Headers setHeaders(CloudRequest cloudRequest, String queryString) throws CloudException {
        Headers header;
        if (Auth.KEYED == cloudRequest.getAuth()) {
            header = Headers.of(
                    GlobalConst.USER_AGENT, USER_AGENT,
                    GlobalConst.X_BM_KEY, this.cloudContext.getCloudKey().getApiKey()
            );
        } else if (Auth.SIGNED == cloudRequest.getAuth()) {
            CloudSignature.Signature signature = CloudSignature.create(queryString, this.cloudContext.getCloudKey().getApiSecret(), this.cloudContext.getCloudKey().getMemo());
            header = Headers.of(
                    GlobalConst.USER_AGENT, USER_AGENT,
                    GlobalConst.X_BM_KEY, this.cloudContext.getCloudKey().getApiKey(),
                    GlobalConst.X_BM_TIMESTAMP, signature.getTimestamp(),
                    GlobalConst.X_BM_SIGN, signature.getSign()
            );
        } else {
            header = Headers.of(
                    GlobalConst.USER_AGENT, USER_AGENT
            );
        }
        return header;
    }

    private CloudResponse getResponse(Map<String, String> paraMap, okhttp3.Call okCall) throws CloudException {
        try {
            Response response = okCall.execute();

            return new CloudResponse()
                    .setResponseContent(response.body().string())
                    .setResponseHttpStatus(response.code())
                    .setCloudLimit(new CloudLimit()
                            .setLimit(Integer.parseInt(StringUtils.defaultIfBlank(response.header("X-BM-RateLimit-Limit"), "0")))
                            .setRemaining(Integer.parseInt(StringUtils.defaultIfBlank(response.header("X-BM-RateLimit-Remaining"), "0")))
                            .setReset(Integer.parseInt(StringUtils.defaultIfBlank(response.header("X-BM-RateLimit-Reset"), "0")))
                    );


        } catch (IOException var18) {
            throw new CloudException("Error: " + var18.getMessage());
        } catch (Exception var19) {
            throw new CloudException("Error: " + var19.getMessage());
        }

    }


}
