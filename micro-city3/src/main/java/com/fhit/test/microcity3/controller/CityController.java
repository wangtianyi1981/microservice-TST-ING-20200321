package com.fhit.test.microcity3.controller;

import com.fhit.test.microcity3.entity.City;
import com.fhit.test.microcity3.service.CityService;
import com.fhit.test.microcommon.entity.Message;
import com.fhit.test.microcommon.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wty
 * @create 2020-04-14 10:57
 */
@RestController
public class CityController {
    /**
     * service 注入mapper(dao)
     *
     * @Controller返回"success.jsp"页面解析
     * @RestController返回"success.jsp"字符串解析
     */

    @Autowired
    CityService cityService;

//    //    @RequestMapping(value = "queryCities", method = RequestMethod.GET)   // 等价 @GetMapping
//    @GetMapping(value = "queryCities")
//    public Message queryCities() {
//        List<City> result = cityService.queryCities();
//        return new Message(true, StatusCode.OK, result);
//    }
//
//    //    @RequestMapping(value = "deleteById/{id}",method = RequestMethod.DELETE)
//    @DeleteMapping(value = "deleteById/{id}")
//    public Message deleteById(@PathVariable("id") Integer id) {
//        boolean result = cityService.deleteById(id);
//        return new Message(true, StatusCode.OK, result);
//    }
//
//    //    @RequestMapping(value = "addCity", method = RequestMethod.POST)   // 等价 @PostMapping
//    @PostMapping(value = "addCity")
//    public Message addCity(@RequestBody City city) {
//        System.out.println("city->"+cityService);
//        boolean result = cityService.addCity(city);
//        return new Message(true, StatusCode.OK, result);
//    }
//
//    //    @RequestMapping(value = "updateCityById",method = RequestMethod.PUT)
//    @PutMapping(value = "updateCityById")
//    public Message updateCityById(@RequestBody City city) {
//        boolean result = cityService.updateCityById(city);
//        return new Message(true, StatusCode.OK, result);
//    }
}
