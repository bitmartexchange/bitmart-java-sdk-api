package com.bitmart.api.request.spot.pub;


import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public final class CurrenciesRequest extends CloudRequest {

    /**
     * Get a list of all cryptocurrencies on the platform
     */
    public CurrenciesRequest() {
        super("/spot/v1/currencies", Method.GET, Auth.NONE);
    }
}
