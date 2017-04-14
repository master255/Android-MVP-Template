package ru.techmas.androidtemplate.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpAppCompatActivity;

import ru.techmas.androidtemplate.R;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseActivity extends MvpAppCompatActivity {

    protected String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    protected final void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    protected final  <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
    }

    @Override
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }

}
