package net.moltak.daggerpractice.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by moltak on 15. 6. 16..
 */
@Module
public class GithubApiModule {
    @Provides @Singleton public RestAdapter provideGithubAdapter() {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
