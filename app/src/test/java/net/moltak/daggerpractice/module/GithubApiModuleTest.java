package net.moltak.daggerpractice.module;

import net.moltak.daggerpractice.data.User;
import net.moltak.daggerpractice.data.UserManager;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import dagger.Module;
import dagger.ObjectGraph;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by moltak on 15. 6. 16..
 */
public class GithubApiModuleTest {

    @Inject UserManager userManager;

    @Before
    public void setUp() throws Exception {
        ObjectGraph.create(new TestModule()).inject(this);
    }

    @Module(
            includes = GithubApiModule.class,
            injects = GithubApiModuleTest.class,
            overrides = true
    )
    static class TestModule {}

    @Test
    public void testUserManager() throws ExecutionException, InterruptedException {
        User u = userManager.getUser("JakeWharton").toBlocking().toFuture().get();
        assertThat(u.email, is("jakewharton@gmail.com"));
    }
}
