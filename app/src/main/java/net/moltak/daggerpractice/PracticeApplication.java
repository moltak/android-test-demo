package net.moltak.daggerpractice;

import android.app.Application;
import android.location.LocationManager;
import android.util.Log;

import net.moltak.daggerpractice.component.AppComponent;
import net.moltak.daggerpractice.component.DaggerAppComponent;
import net.moltak.daggerpractice.module.GithubApiModule;

import javax.inject.Inject;

/**
 * Created by moltak on 15. 6. 15..
 */
public class PracticeApplication extends Application {

    @Inject LocationManager locationManager;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .build();

        getComponent().inject(this);
        Log.d("inject", locationManager.toString());
    }

    public AppComponent getComponent() {
        return component;
    }
}
