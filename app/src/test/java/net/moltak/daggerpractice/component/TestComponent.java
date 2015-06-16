package net.moltak.daggerpractice.component;

import net.moltak.daggerpractice.module.GithubApiModuleTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by moltak on 15. 6. 16..
 */
@Singleton
@Component(dependencies = DaggerAppComponent.class)
interface TestComponent {
    void inject(GithubApiModuleTest githubApiModuleTest);
}
