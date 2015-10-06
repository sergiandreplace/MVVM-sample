package com.blindbugs.wifipedia.domain.data.repository;

import com.blindbugs.wifipedia.domain.model.WifiNetwork;

import java.util.List;

/**
 * Created by sergi on 10/5/15.
 */
public interface ScanWifiRepository {
    public void scanWifis(RepositoryCallback<List<WifiNetwork>> result);
}
