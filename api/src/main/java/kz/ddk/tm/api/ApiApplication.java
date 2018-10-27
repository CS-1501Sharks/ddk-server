package kz.ddk.tm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;


@SpringBootApplication(scanBasePackages = "kz", exclude = { SecurityAutoConfiguration.class })
public class ApiApplication {
    public static void main(String []args){
        SpringApplication.run(ApiApplication.class, args);
    }
}