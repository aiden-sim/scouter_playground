package executor;

import worker.WorkerThread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Runnable (caller 연결 O)
// scouter option
// hook_service_patterns=executor.ExecutorExampleLambdaExpression.main
// hook_async_thread_pool_executor_enabled=true (제약사항으로 threadpool 설정 개수보다 많이 호출되어야됨)
public class ExecutorExampleLambdaExpression {
    private final static Executor executor = Executors.newFixedThreadPool(1,
            runnable -> {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(
                () -> {
                    new WorkerThread().run();
                },
                executor
        );
        System.out.println(cf.get());

        // threadpool 개수를 1로 설정했기 때문에 2회 이상 호출되어야 된다.
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(
                () -> {
                    new WorkerThread().run();
                },
                executor
        );
        System.out.println(cf2.get());
    }
}
