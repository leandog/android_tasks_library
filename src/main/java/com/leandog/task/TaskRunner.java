package com.leandog.task;

import android.os.Handler.Callback;


public interface TaskRunner {

    <Parameter, Result> void run(AsynchronousWork<Parameter, Result> work, Parameter... parameters);

    void run(Callback callback, MessageProvider messageProvider);

}