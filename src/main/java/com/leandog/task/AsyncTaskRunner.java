package com.leandog.task;

import android.os.Handler;
import android.os.Handler.Callback;

public class AsyncTaskRunner implements TaskRunner {

	@Override
	public <Parameter, Result> void run(
			AsynchronousWork<Parameter, Result> work, Parameter... result) {
		new WorkTask<Parameter, Result>(work).execute(result);
	}

	@Override
	public void run(final Callback callback,
			final MessageProvider messageProvider) {
		final Handler handler = new Handler(callback);
		new HandlerCallbackThread(handler, messageProvider).start();
	}
}