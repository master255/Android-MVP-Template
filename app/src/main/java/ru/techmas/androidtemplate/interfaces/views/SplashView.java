package ru.techmas.androidtemplate.interfaces.views;

import com.arellomobile.mvp.MvpView;

public interface SplashView extends MvpView {

    void showErrorConnection();
    void hideErrorConnection();

    void showMainActivity();

}
