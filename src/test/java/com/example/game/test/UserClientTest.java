package com.example.game.test;

import com.iohao.game.action.skeleton.core.IoGameGlobalSetting;
import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.common.kit.InternalKit;
import com.iohao.game.external.client.AbstractInputCommandRegion;
import com.iohao.game.external.client.InputCommandRegion;
import com.iohao.game.external.client.join.ClientRunOne;
import com.iohao.game.external.client.kit.ClientUserConfigs;
import com.example.game.logic.cmd.UserCmdModule;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserClientTest {

    // public static void main(String[] args) {
    //
    //     // 使用 json 编解码
    //     IoGameGlobalSetting.setDataCodec(new JsonDataCodec());
    //
    //     ClientUserConfigs.closeLog();
    //
    //     // 模拟请求数据
    //     List<InputCommandRegion> inputCommandRegions = List.of(
    //             new InternalRegion()
    //     );
    //
    //     // 启动模拟客户端
    //     new ClientRunOne()
    //             .setInputCommandRegions(inputCommandRegions)
    //             .startup();
    // }

    // static class InternalRegion extends AbstractInputCommandRegion {
    //     @Override
    //     public void initInputCommand() {
    //         inputCommandCreate.cmd = UserCmdModule.cmd;
    //
    //         TokenInfo helloReq = new TokenInfo();
    //         helloReq.token = "CbOuCuTpzjbVZi4ptZY21eG8UAEi2VX3D";
    //
    //         ofCommand(UserCmdModule.info).callback(TokenInfo.class, result -> {
    //             TokenInfo value = result.getValue();
    //             log.info("value : {}", value);
    //         }).setDescription("here").setRequestData(helloReq);
    //
    //         // 一秒后，执行模拟请求;
    //         InternalKit.newTimeoutSeconds(task -> {
    //             // 执行 here 请求
    //             ofRequestCommand(UserCmdModule.info).request();
    //         });
    //     }
    // }
}
