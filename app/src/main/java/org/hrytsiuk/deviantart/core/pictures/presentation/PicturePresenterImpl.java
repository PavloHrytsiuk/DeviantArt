package org.hrytsiuk.deviantart.core.pictures.presentation;

import android.support.annotation.NonNull;
import android.util.Log;

import org.hrytsiuk.deviantart.core.pictures.model.Picture;
import org.hrytsiuk.deviantart.core.pictures.domain.PictureInteractor;
import org.hrytsiuk.deviantart.core.pictures.domain.PictureInteractorImpl;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public final class PicturePresenterImpl implements PicturePresenter {

    private final CompositeSubscription subscriptions = new CompositeSubscription();
    private final PictureInteractor interactor;
    private PictureView view;

    public PicturePresenterImpl() {
        interactor = new PictureInteractorImpl();
    }


    @Override
    public void fetchPictures(@NonNull final String accessToken, final int limit) {
        final Subscription subscription = interactor.fetchPictures(accessToken, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Picture>>() {
                    @Override
                    public void onCompleted() {
                        //--
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("TAG", "Access Throwable:" + e.getMessage());
                    }

                    @Override
                    public void onNext(@NonNull final List<Picture> pictures) {
                        view.loadPictures(pictures);
                    }
                });
        subscriptions.add(subscription);
    }

    @Override
    public void fetchAccessToken() {
        final Subscription subscription = interactor.fetchAccessToken()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        //--
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("TAG", "Access Throwable:" + e.getMessage());

                    }

                    @Override
                    public void onNext(@NonNull final String accessToken) {
                        view.saveAccessToken(accessToken);
                    }
                });
        subscriptions.add(subscription);
    }

    @Override
    public void onDestroy() {
        subscriptions.unsubscribe();
    }

    @Override
    public void attachView(@NonNull final PictureView view) {
        this.view = view;
    }


}
