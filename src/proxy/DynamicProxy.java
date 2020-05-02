package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object object;
    private DoCallback doCallback;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public DoCallback getDoCallback() {
        return doCallback;
    }

    public void setDoCallback(DoCallback doCallback) {
        this.doCallback = doCallback;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        doBefore();
        Object obj = method.invoke(object, objects);
        doAfter();
        return obj;
    }

    private void doBefore(){
        if (doCallback!=null) {
            doCallback.doBefore();
        }
    }

    private void doAfter(){
        if (doCallback!=null) {
            doCallback.doAfter();
        }
    }

    public interface DoCallback{
        void doBefore();
        void doAfter();
    }
}
