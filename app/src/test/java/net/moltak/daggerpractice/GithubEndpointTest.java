package net.moltak.daggerpractice;

import net.moltak.daggerpractice.data.RepositoryResponse;
import net.moltak.daggerpractice.data.UserResponse;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by moltak on 15. 6. 16..
 */
public class GithubEndpointTest {

    @Test
    public void testGithubApiResponse() throws ExecutionException, InterruptedException {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        Observable<UserResponse> o = adapter.create(GithubApiService.class).getUser("moltak");
        UserResponse r = o.toBlocking().toFuture().get();

        assertThat(r, notNullValue());
    }

    public interface GithubApiService {
        @GET("/users/{username}")
        Observable<UserResponse> getUser(
                @Path("username") String username
        );

        @GET("/users/{username}/repos")
        Observable<List<RepositoryResponse>> getUsersRepositories(
                @Path("username") String username
        );
    }
}
