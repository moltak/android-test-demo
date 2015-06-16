package net.moltak.daggerpractice.data;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by moltak on 15. 6. 16..
 */
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
