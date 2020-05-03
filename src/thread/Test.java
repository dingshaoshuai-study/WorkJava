package thread;

public class Test {
    private static class WorkThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("线程名称：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        workThread.run();//线程名称：main，就跟普通类、方法一样，可以调用多次，在当前线程执行
        workThread.run();//线程名称：main，就跟普通类、方法一样，可以调用多次，在当前线程执行
        workThread.start();//线程名称：Thread-0，执行在此线程中
        workThread.start();//Error，只能调用一次
    }
}
