package com.example.game.logic.pb;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class LoginVerify {

    String token;
}
