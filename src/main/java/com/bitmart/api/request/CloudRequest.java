package com.bitmart.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CloudRequest {

    /**
     * Request api path
     */
    protected String path;

    /**
     * Request api method
     */
    protected Method method;

    /**
     * Request Interface Authentication Mode
     */
    protected Auth auth;
}
