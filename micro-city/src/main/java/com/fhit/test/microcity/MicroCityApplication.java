package com.fhit.test.microcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author wty
 * @create 2020-04-14 10:18
 */
@CrossOrigin
@SpringBootApplication
public class MicroCityApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCityApplication.class);
    }
}
