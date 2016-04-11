package com.inveitix.android.mvpapp;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.inveitix.android.mvpapp.inteface.HelloWorldView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelloWorldActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter>
        implements HelloWorldView{

    @Bind(R.id.greetingTextView)
    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @OnClick(R.id.helloButton)
    public void onHelloButtonClicked(){
        presenter.greetHello();
    }

    @OnClick(R.id.goodbyeButtonClicked)
    public void onGoodbyeButtonClicked(){
        presenter.greetGoodbye();
    }

    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
