package com.bitmart.websocket;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class OpParam implements Serializable {
    private String op;
    private List<String> args;
}
