package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Create {
    private static class WorkThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("WorkThread");
        }
    }

    private static class WorkRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("WorkRunnable");
        }
    }

    private static class WorkCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("WorkCallable");
            return "result";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread workThread = new WorkThread();
        workThread.start();

        Runnable workRunnable = new WorkRunnable();
        new Thread(workRunnable).start();

        Callable workCallable = new WorkCallable();
        FutureTask<String> futureTask = new FutureTask<>(workCallable);
        Thread taskThread = new Thread(futureTask);
        taskThread.start();
        String result = futureTask.get();
        System.out.println(result);
    }

}
