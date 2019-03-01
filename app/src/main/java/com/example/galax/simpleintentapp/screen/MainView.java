package com.example.galax.simpleintentapp.screen;

import android.view.View;
import android.widget.Button;

import com.example.galax.simpleintentapp.R;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class MainView implements MainContract.View {

    private View root;
    private Button dateBtn;
    private Button timeBtn;

    public MainView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        dateBtn = root.findViewById(R.id.date_btn);
        timeBtn = root.findViewById(R.id.time_btn);
    }

    @Override
    public Observable<Object> dateBtnAction() {
        return RxView.clicks(dateBtn);
    }

    @Override
    public Observable<Object> timeBtnAction() {
        return RxView.clicks(timeBtn);
    }
}
