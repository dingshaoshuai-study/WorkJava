package proxy;

import proxy.feat.IPay;
import proxy.feat.ISend;

public class PayProxy implements IPay, ISend {
    private IPay pay;
    private ISend send;

    public PayProxy(IPay pay, ISend send) {
        this.pay = pay;
        this.send = send;
    }

    @Override
    public void pay() {
        doPayBefore();
        pay.pay();
        doPayAfter();
    }

    private void doPayBefore() {
        System.out.println("准备支付");
    }

    private void doPayAfter() {
        System.out.println("支付完成");
    }

    @Override
    public void send() {
        doSendBefore();
        send.send();
        doSendAfter();
    }

    private void doSendBefore() {
        System.out.println("准备发送信息");
    }

    private void doSendAfter() {
        System.out.println("发送信息完成");
    }
}
