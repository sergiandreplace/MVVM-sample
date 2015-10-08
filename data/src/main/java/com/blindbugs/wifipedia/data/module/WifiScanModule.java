package com.blindbugs.wifipedia.data.module;

import android.content.Context;

import com.blindbugs.wifipedia.data.factory.ScanWifisRepositoryFactoryImpl;
import com.blindbugs.wifipedia.data.repository.wifi.ScanWifiRepositoryImpl;
import com.blindbugs.wifipedia.data.repository.wifi.WifiScanner;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;
import com.blindbugs.wifipedia.domain.interactor.ScanWifisUseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergi on 10/7/15.
 */
@Module
public class WifiScanModule {
    @Provides @Singleton
    ScanWifiRepository providesScanWifiRepository(Context context) {
        return new ScanWifiRepositoryImpl(context);

    }

    @Provides @Singleton
    ScanWifisUseCase provideScanWifiUseCase(Context context) {
        return new ScanWifisUseCase(new ScanWifiRepositoryImpl(context));
    }

}
