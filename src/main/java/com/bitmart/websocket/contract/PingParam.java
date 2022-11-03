package com.bitmart.websocket.contract;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PingParam implements Serializable {
    private String subscribe;
}
