package com.blindbugs.wifipedia.domain.data.repository;

/**
 * Created by sergi on 10/5/15.
 */
public interface RepositoryCallback<T> {
    public void onCallback(T result);
}
