package thread;

public class Stop {
    private static class WorkThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("线程开始 - isInterrupted：" + isInterrupted());
            while (!Thread.interrupted()){
//            while (!isInterrupted()) {
//              while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {//如果正在sleep，调用interrupt会进入这个异常
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println("执行中...");
            }
            System.out.println("线程结束 - isInterrupted：" + isInterrupted());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        WorkThread workThread = new WorkThread();
        workThread.start();
        Thread.sleep(2000);
        //workThread.stop();//已过期，不安全，不推荐使用
        workThread.interrupt();//协作式，需要在此线程中接收并处理
    }
}
