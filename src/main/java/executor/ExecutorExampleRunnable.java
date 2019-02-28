package executor;

import worker.WorkerRunnableThread;
import worker.WorkerThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Runnable
// scouter option
// hook_service_patterns=executor.ExecutorExampleRunnable.main
public class ExecutorExampleRunnable {
    public static void main(String[] args) throws InterruptedException {
        // CASE1 (caller 연결 O)
        // hook_async_callrunnable_scan_package_prefixes=worker
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new WorkerRunnableThread());
        executorService.shutdown();

        // CASE2 (caller 연결 O)
        // hook_async_callrunnable_scan_package_prefixes=executor
        ExecutorService executorService2 = Executors.newFixedThreadPool(1);
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                new WorkerThread().run();
            }
        });
        executorService2.shutdown();

        // CASE3 (caller 연결 O)
        // hook_async_thread_pool_executor_enabled=true (제약사항으로 threadpool 설정 개수보다 많이 호출되어야됨)
        ExecutorService executorService3 = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            executorService3.execute(() -> {
                new WorkerThread().run();
            });
        }
        executorService3.shutdown();
    }
}
