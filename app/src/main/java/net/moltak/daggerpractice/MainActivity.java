package net.moltak.daggerpractice;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((PracticeApplication)getApplication()).getComponent().inject(this);
        Log.d("inject", locationManager.toString());
    }
}
