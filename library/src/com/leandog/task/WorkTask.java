package com.leandog.task;


import android.os.AsyncTask;

class WorkTask<Parameter, Result> extends AsyncTask<Parameter, Integer, Result> {
    private final AsynchronousWork<Parameter, Result> work;

    public WorkTask(AsynchronousWork<Parameter, Result> work) {
        this.work = work;
    }
    
    @Override
    protected void onPreExecute() {
        work.onPreExecute();
    }

    @Override
    protected Result doInBackground(Parameter... params) {
        return work.doInBackground(params);
    }

    @Override
    protected void onPostExecute(Result result) {
        work.onPostExecute(result);
    }
}