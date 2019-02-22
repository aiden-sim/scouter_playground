package runnable;

import worker.WorkerThread;

// Lambda (caller 연결 X)
// scouter option
// hook_service_patterns=runnable.RunnableExampleLambdaExpression.main
// hook_lambda_instrumentation_strategy_enabled=true
public class RunnableExampleLambdaExpression {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			new WorkerThread().run();
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
