package com.fhit.test.microcity.mapper;

import com.fhit.test.microcity.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wty
 * @create 2020-04-14 10:20
 */
@Mapper
public interface CityMapper {
    /**
     * mybatis 接口操作sql
     * 1.注解
     * 2.SQL映射文件
     */


    @Insert("insert into city(id,name,area) value(#{id}, #{name}, #{area})")
    boolean addCity(City city);

    @Delete("delete from city where id = #{id}")
    boolean deleteById(Integer id);

    @Update("update city set name = #{name}, area = #{area} where id = #{id}")
    boolean updateCityById(City city);

    @Select("select * from city")
    List<City> queryCities();
}
