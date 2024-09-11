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
public final class SymbolsRequest extends CloudRequest {

    /**
     * Get a list of all trading pairs on the platform
     */
    public SymbolsRequest() {
        super("/spot/v1/symbols", Method.GET, Auth.NONE);
    }
}
