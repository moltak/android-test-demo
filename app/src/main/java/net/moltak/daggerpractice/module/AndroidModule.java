package net.moltak.daggerpractice.module;

import android.content.Context;
import android.location.LocationManager;

import net.moltak.daggerpractice.PracticeApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by moltak on 15. 6. 16..
 */
@Module(
        library = true
)
public class AndroidModule {
    private final PracticeApplication application;

    public AndroidModule(PracticeApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(Context.LOCATION_SERVICE);
    }
}
