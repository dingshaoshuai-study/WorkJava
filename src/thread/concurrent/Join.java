package thread.concurrent;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        WorkThread workThread = new WorkThread();
        workThread.start();
        workThread.join();//当前线程等待此线程执行结束，再接着执行
        System.out.println("主线程在执行中..");

    }

    private static class WorkThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("WorkThread 线程 - 开始执行");
            try {
                System.out.println("WorkThread 线程 - sleep 开始");
                Thread.sleep(2000);
                System.out.println("WorkThread 线程 - sleep 完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WorkThread 线程 - 执行结束");
        }
    }

}
