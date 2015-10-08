package com.blindbugs.wifipedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.blindbugs.wifipedia.component.DaggerWifiScanComponent;
import com.blindbugs.wifipedia.component.WifiScanComponent;
import com.blindbugs.wifipedia.data.module.WifiScanModule;
import com.blindbugs.wifipedia.domain.data.repository.ScanWifiRepository;
import com.blindbugs.wifipedia.domain.interactor.InteractorCallback;
import com.blindbugs.wifipedia.domain.interactor.ScanWifisUseCase;
import com.blindbugs.wifipedia.domain.model.WifiNetwork;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiScanComponent component = DaggerWifiScanComponent.builder()
                .wifiScanModule(new WifiScanModule())
                .androidModule(new AndroidModule((WifipediaApplication) getApplication()))
                .build();

        ScanWifisUseCase useCase = component.provideScanWifiUseCase();
        useCase.getVisibleWifis(new InteractorCallback<List<WifiNetwork>>() {
            @Override
            public void onCallback(List<WifiNetwork> value) {
                for (WifiNetwork wifiNetwork : value) {
                    Log.d("Wifi", wifiNetwork.ssid);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
