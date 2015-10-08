package com.blindbugs.wifipedia;

import android.app.Application;

import com.blindbugs.wifipedia.component.ApplicationComponent;

/**
 * Created by sergi on 10/7/15.
 */
public class WifipediaApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        /*ApplicationComponent applicationComponent= DaggerWifipediaApplication_ApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
        component.inject(this);*/
    }

    public ApplicationComponent component() {
        return component;
    }
}
