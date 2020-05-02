package proxy.feat.impl;

import proxy.feat.IPay;

public class WechatPay implements IPay {

    @java.lang.Override
    public void pay() {
        System.out.println("支付 - 微信");
    }
}
