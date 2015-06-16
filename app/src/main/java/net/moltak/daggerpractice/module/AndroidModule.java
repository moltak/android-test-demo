package net.moltak.daggerpractice.module;

import android.content.Context;
import android.location.LocationManager;

import net.moltak.daggerpractice.PracticeApplication;
import net.moltak.daggerpractice.annotation.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by moltak on 15. 6. 16..
 */
@Module
public class AndroidModule {
    private final PracticeApplication application;

    public AndroidModule(PracticeApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}
