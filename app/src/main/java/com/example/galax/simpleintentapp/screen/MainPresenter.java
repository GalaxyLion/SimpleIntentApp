package com.example.galax.simpleintentapp.screen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.galax.simpleintentapp.base.BaseActivity;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private CompositeDisposable subscriptions;
    private Intent intent;
    private BaseActivity activity;

    public MainPresenter(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void start(MainContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
        initActions();
    }

    private void initActions() {
        subscriptions.add(view.dateBtnAction().subscribe(
                o->{
                    intent = new Intent("com.example.galax.simpleintentapp.showdate");
                    activity.startActivity(intent);
                }
        ));

        subscriptions.add(view.timeBtnAction().subscribe(
                o ->{
                    intent = new Intent("com.example.galax.simpleintentapp.showtime");
                    activity.startActivity(intent);
                }
        ));
    }

    @Override
    public void stop() {
        subscriptions.dispose();
        subscriptions = null;
    }
}
