package com.blindbugs.wifipedia.domain.interactor;

import com.blindbugs.wifipedia.domain.data.factory.ScanWifisRepositoryFactory;
import com.blindbugs.wifipedia.domain.data.repository.RepositoryCallback;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;
import com.blindbugs.wifipedia.domain.model.WifiNetwork;

import java.util.List;

/**
 * Created by sergi on 10/5/15.
 */
public class ScanWifisUseCase {

    private final ScanWifiRepository repository;

    public ScanWifisUseCase(ScanWifisRepositoryFactory factory) {
        this.repository=factory.getScanWifisRepository();
    }

    public void getVisibleWifis(final InteractorCallback<List<WifiNetwork>> callback) {
        repository.scanWifis(new RepositoryCallback<List<WifiNetwork>>() {
            @Override
            public void onCallback(List<WifiNetwork> result) {
                callback.onCallback(result);
            }
        });
    }


}
