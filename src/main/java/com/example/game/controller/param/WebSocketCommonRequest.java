package com.example.game.controller.param;

import lombok.Data;

@Data
public class WebSocketCommonRequest {

    int cmd;

    Object payload;
}
