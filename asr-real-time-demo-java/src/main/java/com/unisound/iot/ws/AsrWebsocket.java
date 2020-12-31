package com.unisound.iot.ws;

import com.unisound.iot.util.SignCheck;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 实时语音转写demo
 *
 * @author unisound
 * @date 2020/8/25
 */
public class AsrWebsocket {
    public static void main(String[] args) {
        String host = "ws://"+args[0]+":"+args[1]+"/v1/ws?";
        String appkey ="45gn7md5n44aak7a57rdjud3b5l4xdgv75saomys";
        String secret ="ba24a917a38e11e49c6fb82a72e0d896";
        long time = System.currentTimeMillis();
        StringBuilder paramBuilder = new StringBuilder();
        paramBuilder.append(appkey).append(time).append(secret);
        String sign = SignCheck.getSHA256Digest(paramBuilder.toString());

        StringBuilder param = new StringBuilder();
        param.append("appkey=").append(appkey).append("&")
                .append("time=").append(time).append("&")
                .append("sign=").append(sign);
        String str = host + param.toString();
        URI uri = null;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        try {
            Session session = container.connectToServer(new AsrClientEndpoint("audio/unisound.wav"), uri);
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            while (true){
                Thread.sleep(5 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
