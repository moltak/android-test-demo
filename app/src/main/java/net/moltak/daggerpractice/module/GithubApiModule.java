package net.moltak.daggerpractice.module;

import com.squareup.okhttp.OkHttpClient;

import net.moltak.daggerpractice.data.GithubApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by moltak on 15. 6. 16..
 */
@Module
public class GithubApiModule {
    @Provides
    @Singleton
    RestAdapter provideGithubAdapter(OkHttpClient okHttpClient) {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Provides
    @Singleton
    GithubApiService provideGithubApiService(RestAdapter restAdapter) {
        return restAdapter.create(GithubApiService.class);
    }
}
