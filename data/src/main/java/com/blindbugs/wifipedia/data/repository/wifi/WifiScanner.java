package com.blindbugs.wifipedia.data.repository.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * This class retrieves the current visible networks from the list of wifis.
 */
public class WifiScanner extends BroadcastReceiver {

    private final Context context;
    WifiManager wifiManager;
    private WifiScanListener wifiScanListener;

    public WifiScanner(Context context) {
        this.context=context.getApplicationContext();
    }

    /**
     * Initiates a scan for wifi networks
     */
    public void scanWifiNetworks() {
        context.registerReceiver(this, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        getWifiManager().startScan();
    }


    private WifiManager getWifiManager() {
        if (wifiManager==null) {
            wifiManager=(WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        }
        return wifiManager;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (wifiScanListener!=null) {
            wifiScanListener.onWifiScanned(getWifiManager().getScanResults());
        }
    }

    public void setWifiScanListener(WifiScanListener wifiScanListener) {
        this.wifiScanListener = wifiScanListener;
    }

    public interface WifiScanListener {
        public void onWifiScanned(List<ScanResult> result);
    }

}
