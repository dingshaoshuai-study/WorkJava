package proxy.feat.impl;

import proxy.feat.IPay;

public class AliPay implements IPay {
    @Override
    public void pay() {
        System.out.println("支付 - 支付宝");
    }
}
