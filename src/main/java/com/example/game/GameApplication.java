package com.example.game;

import com.example.game.logic.UserLogicServer;
import com.iohao.game.action.skeleton.core.IoGameGlobalSetting;
import com.iohao.game.action.skeleton.core.codec.JsonDataCodec;
import com.iohao.game.action.skeleton.ext.spring.ActionFactoryBeanForSpring;
import com.iohao.game.external.core.netty.simple.NettySimpleHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@MapperScan("com.example.game.mapper")
@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {

        // 1. springboot 启动项
        SpringApplication.run(GameApplication.class, args);

        // 2. 以下是IOGame的配置启动项
        // 2.1 设置json编解码。如果不设置，默认为jprotobuf
        IoGameGlobalSetting.setDataCodec(new JsonDataCodec());
        // 2.2 游戏对外服端口
        int port = 10100;
        // 2.3 逻辑服
        var userLogicServer = new UserLogicServer();
        // 启动 对外服、网关服、逻辑服; 并生成游戏业务文档
        NettySimpleHelper.run(port, List.of(userLogicServer));

        /*
         * 该示例文档地址
         * https://www.yuque.com/iohao/game/evkgnz
         */
    }

    @Bean
    public ActionFactoryBeanForSpring actionFactoryBean() {
        // 将业务框架交给 spring 管理
        return ActionFactoryBeanForSpring.me();
    }
}
