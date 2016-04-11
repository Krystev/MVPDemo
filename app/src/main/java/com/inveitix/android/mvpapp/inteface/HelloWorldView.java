package com.inveitix.android.mvpapp.inteface;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Tito on 5.4.2016 г..
 */
public interface HelloWorldView extends MvpView {

    void showHello(String greetingText);
    void showGoodbye(String greetingText);
}
