package com.leandog.testable.task;

import static junit.framework.Assert.assertEquals;

import android.os.Handler.Callback;

import com.leandog.task.AsynchronousWork;
import com.leandog.task.MessageProvider;
import com.leandog.task.TaskRunner;

public class InlineTaskRunner implements TaskRunner {

	private String workClassName;

	@Override
	public <Parameter, Result> void run(
			AsynchronousWork<Parameter, Result> work, Parameter... params) {
		workClassName = work.getClass().getName();

		work.onPreExecute();
		Result workResult = work.doInBackground(params);
		work.onPostExecute(workResult);
	}

	@Override
	public void run(Callback callback, MessageProvider messageProvider) {
		callback.handleMessage(messageProvider.getMessage());
	}

	public void assertWasExecutedWith(Class<?> workType) {
		assertEquals(workType.getName(), workClassName);
	}

	public void assertWasNotExecuted() {
		assertEquals("Expected not to have executed work but executed \""
				+ workClassName + "\"", null, workClassName);
	}

	public void reset() {
		workClassName = null;
	}
}