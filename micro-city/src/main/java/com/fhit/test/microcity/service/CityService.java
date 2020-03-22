package com.fhit.test.microcity.service;

import com.fhit.test.microcity.entity.City;
import com.fhit.test.microcity.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-14 10:34
 */
@Service
public class CityService {
    /**
     * 标准3层，服务层需要写接口，这里忽略，简单写
     */

    @Autowired(required = false)
    CityMapper cityMapper;

    public boolean addCity(City city) {
        return cityMapper.addCity(city);
    }

    public boolean deleteById(Integer id) {
        return cityMapper.deleteById(id);
    }

    public boolean updateCityById(City city) {
        return cityMapper.updateCityById(city);
    }

    public List<City> queryCities() {
        return cityMapper.queryCities();
    }
}
