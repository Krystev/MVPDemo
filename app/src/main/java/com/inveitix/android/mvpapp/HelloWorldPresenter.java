package com.inveitix.android.mvpapp;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.inveitix.android.mvpapp.inteface.HelloWorldView;

/**
 * Created by Tito on 5.4.2016 г..
 */
public class HelloWorldPresenter extends MvpBasePresenter<HelloWorldView> {

    private GreetingGeneratorTask greetingTask;

    private void cancelGreetingTaskIfRunning(){
        if (greetingTask != null){
            greetingTask.cancel(true);
        }
    }

    public void greetHello(){
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Hello", new GreetingGeneratorTask.GreetingTaskListener(){
            public void onGreetingGenerated(String greetingText){
                if (isViewAttached())
                    getView().showHello(greetingText);
            }
        });
        greetingTask.execute();
    }

    public void greetGoodbye(){
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Goodbye", new GreetingGeneratorTask.GreetingTaskListener(){
            public void onGreetingGenerated(String greetingText){
                if (isViewAttached())
                    getView().showGoodbye(greetingText);
            }
        });
        greetingTask.execute();
    }

    // Called when Activity gets destroyed, so cancel running background task
    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelGreetingTaskIfRunning();
        }
    }
}
