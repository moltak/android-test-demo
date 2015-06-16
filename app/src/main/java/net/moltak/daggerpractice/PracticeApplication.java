package net.moltak.daggerpractice;

import android.app.Application;
import android.location.LocationManager;
import android.util.Log;

import net.moltak.daggerpractice.module.AndroidModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by moltak on 15. 6. 15..
 */
public class PracticeApplication extends Application {

    @Singleton
    @Component(modules = AndroidModule.class)
    public interface ApplicationComponent {
        void inject(PracticeApplication application);
        void inject(MainActivity mainActivity);
    }

    @Inject LocationManager locationManager;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerPracticeApplication_ApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
        component.inject(this);
        Log.d("Log", locationManager.toString());
    }

    public ApplicationComponent component() {
        return component;
    }
}
