package proxy;

import proxy.feat.IPay;
import proxy.feat.ISend;
import proxy.feat.impl.AliPay;
import proxy.feat.impl.AliSend;
import proxy.feat.impl.WechatPay;
import proxy.feat.impl.WechatSend;

public class Client {
//    public static void main(String[] args) {
//        IPay pay = new AliPay();
//        ISend send = new AliSend();
//        PayProxy payProxy = new PayProxy(pay, send);
//        payProxy.pay();
//        payProxy.send();
//
//        System.out.println("-----------------");
//
//        pay = new WechatPay();
//        send = new WechatSend();
//        payProxy = new PayProxy(pay, send);
//        payProxy.pay();
//        payProxy.send();
//    }

    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy();
        proxy.setDoCallback(new DynamicProxy.DoCallback() {
            @Override
            public void doBefore() {
                System.out.println("操作 - 准备");
            }

            @Override
            public void doAfter() {
                System.out.println("操作 - 完成");
                System.out.println("---------------");
            }
        });


        proxy.setObject(new AliPay());
        Object proxyInstance = proxy.getProxyInstance();

        IPay pay = (IPay) proxyInstance;
        pay.pay();

        proxy.setObject(new WechatPay());
        pay.pay();

        proxy.setObject(new AliSend());
        proxyInstance = proxy.getProxyInstance();
        ISend send = (ISend) proxyInstance;
        send.send();

        proxy.setObject(new WechatSend());
        send.send();

    }

}
