package com.fhit.test.microperson2.dao;

import com.fhit.test.microperson2.entity.Person;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-18 21:19
 * jpa使用方式一：继承JpaRepository<Person,String>,JpaSpecificationExecutor<Person>，无需写其它代码
 * JpaRepository：提供了基本的增删改查
 * JpaRepository：提供了较为复杂的条件查询
 */
public interface PersonDao extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {
    /**
     * 推荐方式一：dao层中不用写如何办法，继承JpaRepository、JpaSpecificationExecutor接口，
     * 使用提供的通用办法，缺点：父接口中提供的办法有限。
     */


    /**
     * 推荐方式二：可以自己编写办法，但不用写sql，根据约定写办法的名字。
     */
    public List<Person> findByNameOrderByAgeDesc(String name);

    public List<Person> findByAgeOrderByAge(Integer age);

    /**
     * 方式三：面向对象的sql语句（JPQL）、hibernate（HQL）。
     *
     * @Query("select p from Person p where age = ?1")，其中Person是对象并非表名
     */
    @Query("select p from Person p where age = ?1")
    public List<Person> findByAgeAse(Integer age);

    /**
     * 查询分页功能，通过pageable参数进行分页
     */
    @Query("select p from Person p where age = ?1")
    public List<Person> findByAgeAseByPage(Integer age, Pageable pageable);

    /**
     * 增、删、改功能@Query+@Modify，不支持insert操作
     * 建议在service办法前加@Transactional注解
     */
    @Modifying
    @Query("update Person set age=?1")
    public int updatePerson(Integer id);

    /**
     * 注意：参数id的类型，这个办法没测试过
     *
     * @param id
     * @param person
     * @return
     */
    @Modifying
    @Query("update Person p set p.age=:#{#person.age} where p.id=:#{#person.id}")
    public int updatePerson2(Integer id, Person person);

    /**
     * 推荐方式四：原生态sql语句
     */
    @Query(nativeQuery = true, value = "select name from person where id = ?")
    public String findNameById(String id);

    @Query(nativeQuery = true, value = "select * from person where name = ? and age = ?")
    public List<Person> findPersonByNameAndAge(String name, int age);

    @Query(nativeQuery = true, value = "select * from person where age in (:ages) order by age")
    public List<Person> findPersonByAges(@Param("ages") List<Integer> ages, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from person where age in (:ages) order by age")
    public Page<Person> findPersonByAges2(@Param("ages") List<Integer> ages, Pageable pageable);
}
