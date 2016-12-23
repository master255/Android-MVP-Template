package ru.techmas.androidteamplate.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.techmas.androidteamplate.App;
import ru.techmas.androidteamplate.api.RestApi;
import ru.techmas.androidteamplate.presenters.BaseFragmentPresenter;
import ru.techmas.androidteamplate.utils.PreferenceHelper;
import ru.techmas.androidteamplate.interfaces.view.BaseFragmentView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseFragment extends MvpAppCompatFragment implements BaseFragmentView{

    protected String TAG;

    //@formatter:off
    @InjectPresenter BaseFragmentPresenter baseFragmentPresenter;
    @Inject protected RestApi restApi;
    @Inject protected PreferenceHelper preferenceHelper;
    //@formatter:on

    public ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDagger();
        setupTag();
    }


    private void setupTag() {
        TAG = this.getClass().getSimpleName();
    }

    private void injectDagger() {
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
    }



    protected void startBus() {
        EventBus.getDefault().register(this);
    }//use this only on presenter

    protected void stopBus() {
        EventBus.getDefault().unregister(this);
    }//use this only on presenter

    protected void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void startProgress() {

    }

    @Override
    public void stopProgress() {

    }

    @Override
    public void showProgress(boolean progress) {
        baseFragmentPresenter.doSomeThingWithProgress(progress);
    }
}