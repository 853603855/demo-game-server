package com.example.game.logic.pb;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.mybatisflex.core.paginate.Page;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class PageResp {

    Page page;
}
