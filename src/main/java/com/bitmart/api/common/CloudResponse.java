package com.bitmart.api.common;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class CloudResponse implements Serializable {
    private String responseContent;
    private int responseHttpStatus;
    private CloudLimit cloudLimit;
}
