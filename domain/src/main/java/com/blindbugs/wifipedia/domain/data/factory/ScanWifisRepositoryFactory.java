package com.blindbugs.wifipedia.domain.data.factory;

import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;

/**
 * Created by sergi on 10/5/15.
 */
public interface ScanWifisRepositoryFactory {
    public ScanWifiRepository getScanWifisRepository();
}
