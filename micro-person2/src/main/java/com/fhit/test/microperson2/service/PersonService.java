package com.fhit.test.microperson2.service;

import com.fhit.test.microperson2.dao.PersonDao;
import com.fhit.test.microperson2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-18 21:24
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    /**
     * 推荐方式一：dao层中不用写如何办法，继承JpaRepository、JpaSpecificationExecutor接口，
     * 使用提供的通用办法，缺点：父接口中提供的办法有限。
     */
    public Person savaPerson(Person person) {
        return personDao.save(person);
    }

    /**
     * jpa底层，修改和增加都是save
     */
    public Person updatePerson(Person person) {
        return personDao.save(person);
    }

    public void deletePersonById(String id) {
        personDao.deleteById(id);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person findAllById(String id) {
        return personDao.findById(id).get();
    }

    /**
     * 推荐方式二：可以自己编写办法，但不用写sql，根据约定写办法的名字。
     */
    public List<Person> findByNameOrderByAgeDesc(String name) {
        return personDao.findByNameOrderByAgeDesc(name);
    }

    /**
     * 方式三：面向对象的sql语句（JPQL）、hibernate（HQL）。
     *
     * @Query("select p from Person p where age = ?1")，其中Person是对象并非表名
     */
    public List<Person> findByAgeAse(Integer age) {
        return personDao.findByAgeAse(age);
    }

    /**
     * 查询分页功能，通过pageable参数进行分页
     */
    public List<Person> findByAgeAseByPage(Integer age, int currentPage, int pageSize) {
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);
        return personDao.findByAgeAseByPage(age, pageable);
    }

    /**
     * 增、删、改功能@Query+@Modify，不支持insert操作
     * 建议在service办法前加@Transactional注解
     */
    @Transactional
    public int updatePerson(Integer id) {
        return personDao.updatePerson(id);
    }


    @Transactional
    public int updatePerson2(Integer id, Person person) {
        return personDao.updatePerson2(id, person);
    }

    /**
     * 推荐方式四：原生态sql语句
     */
    public String findNameById(String id) {
        return personDao.findNameById(id);
    }

    public List<Person> findPersonByNameAndAge(String name, int age) {
        return personDao.findPersonByNameAndAge(name, age);
    }

    public List<Person> findPersonByAges(List<Integer> ages, int currentPage, int pageSize) {
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);
        return personDao.findPersonByAges(ages, pageable);
    }

    public Page<Person> findPersonByAges2(List<Integer> ages, int currentPage, int pageSize) {
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);
        return personDao.findPersonByAges2(ages, pageable);
    }
}
