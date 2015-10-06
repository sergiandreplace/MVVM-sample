package com.blindbugs.wifipedia.data.repository.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;

import com.blindbugs.wifipedia.domain.data.repository.RepositoryCallback;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;
import com.blindbugs.wifipedia.domain.model.WifiNetwork;

import java.util.List;

/**
 * Created by sergi on 10/6/15.
 */
public class ScanWifiRepositoryImpl implements ScanWifiRepository, WifiScanner.WifiScanListener {

    private final Context context
            ;
    RepositoryCallback<List<WifiNetwork>> callback;

    public ScanWifiRepositoryImpl(Context context) {
        this.context=context;
    }

    @Override
    public void scanWifis(RepositoryCallback<List<WifiNetwork>> callback) {
        this.callback=callback;
        WifiScanner scanner=new WifiScanner(context);
        scanner.setWifiScanListener(this);
        scanner.scanWifiNetworks();
    }


    @Override
    public void onWifiScanned(List<ScanResult> result) {
        if (callback!=null) {
            callback.onCallback(WifiScanMapper.getWifiNetworks(result));
        }
    }
}
