package com.inveitix.android.mvpapp;

import android.os.AsyncTask;

/**
 * Created by Tito on 5.4.2016 г..
 */
public class GreetingGeneratorTask extends AsyncTask<Void, Void, Integer> {

    public interface GreetingTaskListener{
        void onGreetingGenerated(String greetingText);
    }

    private String baseText;
    private GreetingTaskListener listener;

    public GreetingGeneratorTask(String baseText, GreetingTaskListener listener){
        this.baseText = baseText;
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        try {
            Thread.sleep(2000); // Simulate computing
        } catch (InterruptedException e) { }

        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer randomInt){
        listener.onGreetingGenerated(baseText + " "+randomInt);
    }
}
