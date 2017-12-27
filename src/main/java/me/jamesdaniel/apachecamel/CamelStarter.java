package me.jamesdaniel.apachecamel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class CamelStarter {
    public static void main(String... args) {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new IntegrationRoute());
            context.start();
            Thread.sleep(10000);
            context.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SpringApplication.run(CamelStarter.class, args);
    }
}
