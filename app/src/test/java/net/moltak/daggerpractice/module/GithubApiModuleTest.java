package net.moltak.daggerpractice.module;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by moltak on 15. 6. 16..
 */
public class GithubApiModuleTest {

    GithubApiModule githubApiModule;

    @Before
    public void setUp() throws Exception {
        githubApiModule = new GithubApiModule();
    }

    @Test
    public void testInjectGithubApiModule() {
        assertThat(githubApiModule, notNullValue());
    }


}
