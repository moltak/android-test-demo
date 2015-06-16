package net.moltak.daggerpractice.component;

import net.moltak.daggerpractice.MainActivity;
import net.moltak.daggerpractice.PracticeApplication;
import net.moltak.daggerpractice.module.AndroidModule;
import net.moltak.daggerpractice.module.GithubApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by moltak on 15. 6. 16..
 */
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
