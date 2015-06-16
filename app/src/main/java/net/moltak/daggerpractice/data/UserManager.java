package net.moltak.daggerpractice.data;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by moltak on 15. 6. 16..
 */
public class UserManager {
    private GithubApiService githubApiService;

    public UserManager(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    public Observable<User> getUser(String username) {
        return githubApiService.getUser(username)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
