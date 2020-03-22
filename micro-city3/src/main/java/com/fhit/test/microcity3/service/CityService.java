package com.fhit.test.microcity3.service;

import com.fhit.test.microcity3.entity.City;
import com.fhit.test.microcity3.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-14 10:34
 */

public class CityService {
    /**
     * 标准3层，服务层需要写接口，这里忽略，简单写
     */

    private CityDao cityDao;

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    //    public boolean addCity(City city) {
//        return cityDao.addCity(city);
//    }
//
//    public boolean deleteById(Integer id) {
//        return cityDao.deleteById(id);
//    }
//
//    public boolean updateCityById(City city) {
//        return cityDao.updateCityById(city);
//    }
//
//    public List<City> queryCities() {
//        return cityDao.queryCities();
//    }
}
