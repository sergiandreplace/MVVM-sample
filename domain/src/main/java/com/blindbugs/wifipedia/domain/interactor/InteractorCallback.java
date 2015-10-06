package com.blindbugs.wifipedia.domain.interactor;

/**
 * Created by sergi on 10/5/15.
 */
public interface InteractorCallback<T> {
    public void onCallback(T value);
}
