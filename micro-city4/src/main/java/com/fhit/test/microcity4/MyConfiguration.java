package com.fhit.test.microcity4;

import com.fhit.test.microcity4.dao.CityDao;
import com.fhit.test.microcity4.service.CityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wty
 * @create 2020-03-18 16:48
 * 配置类
 */

@Configuration
public class MyConfiguration {
    @Bean
    public CityService cityService() {
        CityService cityService = new CityService();
        CityDao cityDao = new CityDao();
        cityService.setCityDao(cityDao);

        return cityService;
    }
}
