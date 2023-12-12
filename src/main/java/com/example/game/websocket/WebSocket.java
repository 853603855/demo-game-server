package com.example.game.websocket;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONUtil;
import com.example.game.controller.param.WebSocketCommonRequest;
import com.example.game.dto.UserSimpleInfo;
import com.example.game.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint(value = "/websocket/{token}")
@Component
public class WebSocket {
    private static ConcurrentHashMap<String, WebSocket> webSocketMap = new ConcurrentHashMap<>();
    //实例一个session，这个session是websocket的session
    private Session session;

    public static ConcurrentHashMap<String, WebSocket> getWebSocketMap() {
        return webSocketMap;
    }

    public static void setWebSocketMap(ConcurrentHashMap<String, WebSocket> webSocketMap) {
        WebSocket.webSocketMap = webSocketMap;
    }

    /**
     * 开启一个websocket时，调用
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {

        if(!StringUtils.hasText(token)){
            throw new RuntimeException("token参数为空，链接异常...");
        }

        Object userId = StpUtil.getLoginIdByToken(token);
        String userIdStr = String.valueOf(userId);

        // 建立连接和用户之间的关系
        this.session = session;
        webSocketMap.put(userIdStr, this);
        log.info("【发现新的连接】 -> userId = "+userIdStr + "，token = " + token);
    }

    /**
     * 关闭一个websocket时，调用
     */
    @OnClose
    public void onClose(@PathParam("token") String token) {
        Object userId = StpUtil.getLoginIdByToken(token);
        webSocketMap.remove(userId);
        log.info("【连接断开】 -> userId = " + userId + "，当前连接数:"+ webSocketMap.size());
    }

    /**
     * 接受到一个前端发送来的消息时，处理
     */
    @OnMessage
    public void onMessage(@PathParam("token") String token, String message) {
        if (!message.equals("ping")) {
            System.out.println("【websocket消息】收到客户端发来的消息:"+message);
        }
        // 获取用户ID
        Object userId = StpUtil.getLoginIdByToken(token);
        // 调处理逻辑
        SaResult result = handler(message, Integer.valueOf(userId.toString()));
        // 返回处理结果
        sendMessage(JSONUtil.toJsonStr(result), String.valueOf(userId));
    }

    private static WebSocket webSocket;

    @PostConstruct
    public void init() {
        // 初使化时将已静态化的Service实例化
        webSocket = this;
    }

    @Resource
    private UserService userService;

    public SaResult handler(String message, Integer userId){

        WebSocketCommonRequest request = JSONUtil.toBean(message, WebSocketCommonRequest.class);

        if(request.getCmd() == 10001){// 获取用户信息
            UserSimpleInfo user = webSocket.userService.getUserSimpleInfo(userId);
            return SaResult.data(user);
        }
        return SaResult.error("未匹配对应的cmd");
    }

    //新增一个方法用于主动向客户端发送消息
    public static void sendMessage(Object message, String userId) {

        WebSocket webSocket = webSocketMap.get(userId);
        if (webSocket != null) {
            try {
                webSocket.session.getBasicRemote().sendText(JSONUtil.toJsonStr(message));
                log.info("【发送消息】 -> userId = " + userId + "，消息内容 = " + message.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}