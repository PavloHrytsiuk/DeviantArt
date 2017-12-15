package org.hrytsiuk.deviantart.core;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.hrytsiuk.deviantart.R;
import org.hrytsiuk.deviantart.base.BaseActivity;
import org.hrytsiuk.deviantart.base.OnItemClickListener;
import org.hrytsiuk.deviantart.core.pictures.adapter.PictureAdapter;
import org.hrytsiuk.deviantart.core.pictures.model.Picture;
import org.hrytsiuk.deviantart.core.pictures.PicturePref;
import org.hrytsiuk.deviantart.core.pictures.presentation.PicturePresenter;
import org.hrytsiuk.deviantart.core.pictures.presentation.PicturePresenterImpl;
import org.hrytsiuk.deviantart.core.pictures.presentation.PictureView;
import org.hrytsiuk.deviantart.utils.NetworkUtils;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class MainActivity extends BaseActivity implements PictureView, OnItemClickListener {

    private static final String ACCESS_TOKEN = "Access token";
    private static final String CLICKED_PICTURE = "Pictures list";
    private PicturePresenter presenter;
    private PicturePref preference;
    private PictureAdapter adapter;
    List<Picture> pictures;

    @BindView(R.id.pictureRecycle)
    RecyclerView pictureRecycle;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (NetworkUtils.isNetworkConnected(this)) {
            presenter = new PicturePresenterImpl();
            presenter.attachView(this);
            presenter.fetchAccessToken();
            preference = new PicturePref(this);
            pictureRecycle.setLayoutManager(new LinearLayoutManager(this));
        } else {
            showToast(getString(R.string.message_no_connection));
        }
    }

    @Override
    public void saveAccessToken(@NonNull String accessToken) {
        preference.saveStringData(accessToken, ACCESS_TOKEN);
        presenter.fetchPictures(accessToken, 120);
    }

    @Override
    public void loadPictures(@NonNull List<Picture> pictures) {
        adapter = new PictureAdapter(pictures, this);
        pictureRecycle.setAdapter(adapter);
        this.pictures = pictures;
    }

    @Override
    public void onItemClick(final int position) {
        final Intent intent = new Intent(this, PictureDetailActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putParcelable(CLICKED_PICTURE, pictures.get(position));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
