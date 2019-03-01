package com.example.galax.simpleintentapp.screen;

import io.reactivex.Observable;

public interface MainContract {
    interface View{
        Observable <Object> dateBtnAction();
        Observable <Object> timeBtnAction();
    }
    interface Presenter{
        void start(View view);
        void stop();
    }
}
