package play;

import java.util.concurrent.*;

public class AboutExecutor {

    private static int corePoolSize;

    private static int maximumPoolSize;

    private static int keepAliveTime;

    private static BlockingQueue<Runnable> workQueue;

    private static ThreadFactory myThreadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    };

    private static RejectedExecutionHandler myRejectHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    };

    private static ExecutorService executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime, TimeUnit.SECONDS,
            workQueue,
            myThreadFactory,
            myRejectHandler
    );

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        executor.submit(r);
        executor.execute(r);
    }
}
