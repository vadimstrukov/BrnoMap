package cz.brno.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by strukov on 6/29/16.
 */
@SpringBootApplication
public class BrnomapApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BrnomapApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BrnomapApplication.class);
    }
}
