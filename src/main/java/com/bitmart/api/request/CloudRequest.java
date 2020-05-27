package com.bitmart.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CloudRequest {

    protected String path;

    protected Method method;

    protected Auth auth;
}
