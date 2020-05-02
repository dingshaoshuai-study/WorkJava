package proxy.feat.impl;

import proxy.feat.ISend;

public class AliSend implements ISend {
    @Override
    public void send() {
        System.out.println("发送信息 - 支付宝");
    }
}
