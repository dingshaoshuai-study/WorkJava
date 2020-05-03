package thread.concurrent.wait;

public class Wait1 {
    private static String str;


    public static void main(String[] args) throws InterruptedException {
        WorkThread2 workThread2 = new WorkThread2();
        workThread2.start();
        workThread2.join();

        System.out.println("-------------------");

        WorkThread3 workThread3 = new WorkThread3();
        workThread3.start();
        Thread.sleep(2000);
        System.out.println("主线程 - 尝试唤醒workThread3");
        Thread.sleep(2000);
        System.out.println("主线程 - 唤醒workThread3");
        synchronized (workThread3) {
            str = "hello";
            workThread3.notify();
        }
    }

    private static class WorkThread2 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("WorkThread2 线程 - 开始执行");
            try {
                System.out.println("WorkThread2 线程 - wait 开始");
                synchronized (this) {
                    wait(1000);
                }
                System.out.println("WorkThread2 线程 - wait 完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WorkThread2 线程 - 执行结束");
        }
    }

    private static class WorkThread3 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("WorkThread3 线程 - 开始执行");
            try {
                System.out.println("WorkThread3 线程 - wait 开始");
                synchronized (this) {
                    while (str == null || "".equals(str)) {
                        wait();
                    }
                }
                System.out.println("WorkThread3 线程 - wait 完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WorkThread3 线程 - 执行结束");
        }
    }
}
