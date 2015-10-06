package com.blindbugs.wifipedia.data.factory;

import android.content.Context;

import com.blindbugs.wifipedia.data.repository.wifi.ScanWifiRepositoryImpl;
import com.blindbugs.wifipedia.domain.data.factory.ScanWifisRepositoryFactory;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;

/**
 * Created by sergi on 10/6/15.
 */
public class ScanWifisRepositoryFactoryImpl implements ScanWifisRepositoryFactory {

    private final Context context;

    public ScanWifisRepositoryFactoryImpl(Context context) {
        this.context= context.getApplicationContext();
    }
    @Override
    public ScanWifiRepository getScanWifisRepository() {
        return new ScanWifiRepositoryImpl(context);
    }
}
