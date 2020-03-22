package com.fhit.test.microperson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author wty
 * @create 2020-03-18 19:31
 */
@CrossOrigin
@SpringBootApplication
public class MicroPersonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroPersonApplication.class);
    }
}
