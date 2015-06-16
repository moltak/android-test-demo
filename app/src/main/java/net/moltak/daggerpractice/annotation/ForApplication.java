package net.moltak.daggerpractice.annotation;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by moltak on 15. 6. 16..
 */
@Qualifier @Retention(RUNTIME)
public @interface ForApplication {
}
