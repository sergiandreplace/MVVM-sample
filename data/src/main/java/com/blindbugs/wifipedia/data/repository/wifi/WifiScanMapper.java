package com.blindbugs.wifipedia.data.repository.wifi;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;

import com.blindbugs.wifipedia.domain.model.WifiNetwork;
import com.blindbugs.wifipedia.domain.model.WifiSecurity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergi on 10/6/15.
 */
public class WifiScanMapper {

    /**
     * Converts a ScanResult wifi into a WifiNetwork
     * @param scanResult
     * @return
     */
    public static WifiNetwork getWifiNetwrork(ScanResult scanResult) {
        WifiNetwork wifiNetwork=new WifiNetwork();
        wifiNetwork.ssid=scanResult.SSID;
        wifiNetwork.bssid = scanResult.BSSID;
        wifiNetwork.freq=scanResult.frequency;
        wifiNetwork.level=scanResult.level;
        wifiNetwork.capabilities =scanResult.capabilities;
        return wifiNetwork;
    }

    public static List<WifiNetwork> getWifiNetworks(List<ScanResult> scanResults) {
        List<WifiNetwork> wifiNetworks=new ArrayList<WifiNetwork>(scanResults.size());
        for (ScanResult scanResult : scanResults) {
            wifiNetworks.add(getWifiNetwrork(scanResult));
        }
        return wifiNetworks;
    }

}
