package com.github.panghy;

import com.github.panghy.api.TestApi;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JettyNIOBufferTestApplication extends Application<JettyNIOBufferTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JettyNIOBufferTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "JettyNIOBufferTest";
    }

    @Override
    public void initialize(final Bootstrap<JettyNIOBufferTestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final JettyNIOBufferTestConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new TestApi());
    }

}
