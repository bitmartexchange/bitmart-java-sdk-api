package com.bitmart.websocket.contract;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class ActionParam implements Serializable {
    private String action;
    private List<String> args;
}

