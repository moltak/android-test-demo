package net.moltak.daggerpractice.component;

import net.moltak.daggerpractice.module.GithubApiModule;

import dagger.Component;

/**
 * Created by moltak on 15. 6. 16..
 */
@Component(modules = {GithubApiModule.class})
public interface GithubApiComponent {

    void inject(Object object);
}
