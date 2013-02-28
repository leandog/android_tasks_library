package com.leandog.task;

public interface AsynchronousWork<Parameter, Result> {

    void onPreExecute();
    Result doInBackground(Parameter...parameters);
    void onPostExecute(Result result);
    
}
