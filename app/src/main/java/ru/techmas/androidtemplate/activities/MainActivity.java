package ru.techmas.androidtemplate.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.interfaces.views.MainView;
import ru.techmas.androidtemplate.presenters.MainActivityPresenter;

public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main;

    @InjectPresenter
    MainActivityPresenter mainPresenter;

    @ProvidePresenter
    MainActivityPresenter provideMainActivityPresenter() {
        return App.getAppComponent().getMainActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

    }


    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}