package com.blindbugs.wifipedia.component;

import android.app.Application;

import com.blindbugs.wifipedia.AndroidModule;
import com.blindbugs.wifipedia.WifipediaApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sergi on 10/7/15.
 */
@Singleton
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {
    void inject(WifipediaApplication application);

}
