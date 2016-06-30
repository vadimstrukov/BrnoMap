package cz.brno.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by strukov on 6/29/16.
 */
@SpringBootApplication
public class BrnomapApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrnomapApplication.class, args);
    }
}
