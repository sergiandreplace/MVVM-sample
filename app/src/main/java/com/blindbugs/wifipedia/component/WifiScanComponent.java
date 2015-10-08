package com.blindbugs.wifipedia.component;

import android.content.Context;

import com.blindbugs.wifipedia.AndroidModule;
import com.blindbugs.wifipedia.data.module.WifiScanModule;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;
import com.blindbugs.wifipedia.domain.interactor.ScanWifisUseCase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sergi on 10/7/15.
 */
@Singleton
@Component( modules= {WifiScanModule.class,AndroidModule.class})
public interface WifiScanComponent {

    ScanWifisUseCase provideScanWifiUseCase();
    ScanWifiRepository providesScanWifiRepository();
    Context provideApplicationContext();

}
