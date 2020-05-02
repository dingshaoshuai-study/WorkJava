package proxy.feat.impl;

import proxy.feat.ISend;

public class WechatSend implements ISend {
    @Override
    public void send() {
        System.out.println("发送信息 - 微信");
    }
}
