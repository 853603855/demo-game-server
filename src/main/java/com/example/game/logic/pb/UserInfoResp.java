package com.example.game.logic.pb;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.example.game.entity.User;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UserInfoResp {

    User user;
}
