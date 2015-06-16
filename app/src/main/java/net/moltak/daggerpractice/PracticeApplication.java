package net.moltak.daggerpractice;

import android.app.Application;
import android.location.LocationManager;

import net.moltak.daggerpractice.module.AndroidModule;
import net.moltak.daggerpractice.module.GithubApiModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;


/**
 * Created by moltak on 15. 6. 15..
 */
public class PracticeApplication extends Application {

    private ObjectGraph graph;

    @Inject LocationManager locationManager;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new GithubApiModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }
}
