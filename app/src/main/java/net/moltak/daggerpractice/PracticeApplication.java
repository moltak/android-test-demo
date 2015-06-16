package net.moltak.daggerpractice;

import android.app.Application;
import android.location.LocationManager;
import android.util.Log;

import net.moltak.daggerpractice.module.AndroidModule;
import net.moltak.daggerpractice.module.GithubApiModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by moltak on 15. 6. 15..
 */
public class PracticeApplication extends Application {

    @Inject LocationManager locationManager;
    private AppComponent component;

    @Singleton
    @Component(
            modules = {
                    AndroidModule.class,
                    GithubApiModule.class
            })
    public interface AppComponent {
        void inject(PracticeApplication practiceApplication);
        void inject(MainActivity mainActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerPracticeApplication_AppComponent.builder()
                .androidModule(new AndroidModule(this))
                .githubApiModule(new GithubApiModule())
                .build();

        getComponent().inject(this);
        Log.d("inject", locationManager.toString());
    }

    public AppComponent getComponent() {
        return component;
    }
}
