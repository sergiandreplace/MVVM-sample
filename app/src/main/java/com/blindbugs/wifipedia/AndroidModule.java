package com.blindbugs.wifipedia;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergi on 10/7/15.
 */
@Module
public class AndroidModule {
    private final WifipediaApplication application;

    public AndroidModule(WifipediaApplication application) {
        this.application=application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }
}
