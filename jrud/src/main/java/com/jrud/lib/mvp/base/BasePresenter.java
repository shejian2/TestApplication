package com.jrud.lib.mvp.base;

import android.support.annotation.NonNull;

import java.util.LinkedList;

import rx.Subscription;

public class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V view;

    private final LinkedList<Subscription> registerSubscriptions = new LinkedList<>();

    public BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public boolean isViewAttach() {
        return view!=null;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    protected void addSubscription(Subscription subscription) {
        synchronized (registerSubscriptions) {
            registerSubscriptions.add(subscription);
        }
    }

    protected boolean removeSubscription(@NonNull Subscription subscription) {
        synchronized (registerSubscriptions) {
            return registerSubscriptions.remove(subscription);
        }
    }

    protected boolean cancelSubscription(@NonNull Subscription subscription) {
        if (!subscription.isUnsubscribed()) subscription.unsubscribe();
        return removeSubscription(subscription);
    }

    @Override
    public void destroy() {
        detachView();
        if (registerSubscriptions.isEmpty()) {
            return;
        }
        synchronized (registerSubscriptions) {
            for (Subscription subscription : registerSubscriptions) {
                if (!subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }
            }
            registerSubscriptions.clear();
        }
    }

}
