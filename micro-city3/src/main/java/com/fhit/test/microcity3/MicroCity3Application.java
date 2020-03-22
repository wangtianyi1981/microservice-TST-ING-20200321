package com.fhit.test.microcity3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author wty
 * @create 2020-03-14 10:18
 */
@CrossOrigin
@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
public class MicroCity3Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroCity3Application.class);
    }
}
