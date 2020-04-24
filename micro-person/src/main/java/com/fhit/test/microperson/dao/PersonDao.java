package com.fhit.test.microperson.dao;

import com.fhit.test.microperson.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author wty
 * @create 2020-04-18 21:19
 * jpa使用方式一：继承JpaRepository<Person,String>,JpaSpecificationExecutor<Person>，无需写其它代码
 * JpaRepository：提供了基本的增删改查
 * JpaRepository：提供了较为复杂的条件查询
 */
public interface PersonDao extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {

}
