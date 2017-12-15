package org.hrytsiuk.deviantart.base;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.hrytsiuk.deviantart.base.mvp.BaseView;
import org.hrytsiuk.deviantart.network.rx.RetrofitException;



@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    public void showProgress(final boolean visible) {
        // no-op
    }

    @Override
    public void httpError(@NonNull RetrofitException e) {
        showToast("Http error");
    }

    @Override
    public void showToast(@NonNull final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
