package com.fhit.test.microcity4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author wty
 * @create 2020-04-14 10:18
 */
@CrossOrigin
@SpringBootApplication
public class MicroCity4Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroCity4Application.class);
    }
}
