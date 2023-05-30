package com.bitmart.api.key;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Data
public final class CloudKey {

    @NonNull
    private String apiKey;

    @NonNull
    private String apiSecret;

    @NonNull
    private String memo;

    public CloudKey() {
        this.apiKey = "";
        this.apiSecret = "";
        this.memo = "";
    }

    public CloudKey(@NonNull String apiKey, @NonNull String apiSecret, @NonNull String memo) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.memo = memo;
    }

}
