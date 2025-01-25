package com.bitmart.api.common;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class CloudLimit implements Serializable {
    private int remaining;
    private int limit;
    private int reset;
    private String mode;
}
