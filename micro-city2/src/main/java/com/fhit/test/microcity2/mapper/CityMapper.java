package com.fhit.test.microcity2.mapper;

import com.fhit.test.microcity2.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-14 10:20
 */
@Mapper
public interface CityMapper {
    /**
     * mybatis 接口操作sql
     * 1.*Mapper.xml
     * 2.SQL映射文件
     */

    boolean addCity(City city);

    boolean deleteById(Integer id);

    boolean updateCityById(City city);

    List<City> queryCities();
}
