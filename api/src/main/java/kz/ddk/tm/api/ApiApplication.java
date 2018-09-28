package kz.ddk.tm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "kz")
public class ApiApplication {
    public static void main(String []args){
        SpringApplication.run(ApiApplication.class);
    }
}