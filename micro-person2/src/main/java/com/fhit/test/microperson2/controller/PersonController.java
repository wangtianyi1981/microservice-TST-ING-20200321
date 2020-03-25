package com.fhit.test.microperson2.controller;

import com.fhit.test.microcommon.entity.Message;
import com.fhit.test.microcommon.entity.StatusCode;
import com.fhit.test.microperson2.entity.Person;
import com.fhit.test.microperson2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wty
 * @create 2020-03-18 21:39
 */
@RestController
//@RequestMapping(value = "Person")
public class PersonController {
    @Autowired
    PersonService personService;

    /**
     * 推荐方式一：dao层中不用写如何办法，继承JpaRepository、JpaSpecificationExecutor接口，
     * 使用提供的通用办法，缺点：父接口中提供的办法有限。
     */
    //    @RequestMapping(value = "queryPersons", method = RequestMethod.GET)   // 等价 @GetMapping
    @GetMapping(value = "queryPersons")
    public Message queryPersons() {
        List<Person> result = personService.findAll();
        return new Message(true, StatusCode.OK, result);
    }

    //    @RequestMapping(value = "deleteById/{id}",method = RequestMethod.DELETE)
    @DeleteMapping(value = "deleteById/{id}")
    public Message deleteById(@PathVariable("id") Integer id) {
        personService.deletePersonById(id.toString());
        return new Message(true, StatusCode.OK, true);
    }

    //    @RequestMapping(value = "addPerson", method = RequestMethod.POST)   // 等价 @PostMapping
    @PostMapping(value = "addPerson")
    public Message addPerson(@RequestBody Person person) {
        System.out.println("city->" + personService);
        Person result = personService.savaPerson(person);
        return new Message(true, StatusCode.OK, result);
    }

    //    @RequestMapping(value = "updatePersonById",method = RequestMethod.PUT)
    @PutMapping(value = "updatePersonById")
    public Message updatePersonById(@RequestBody Person person) {
        Person result = personService.updatePerson(person);
        return new Message(true, StatusCode.OK, result);
    }

    /**
     * 推荐方式二：可以自己编写办法，但不用写sql，根据约定写办法的名字。
     */
    @GetMapping(value = "/jpa2/queryPersons/{name}")
    public Message findByNameOrderByAgeDesc(@PathVariable("name") String name) {
        List<Person> result = personService.findByNameOrderByAgeDesc(name);
        return new Message(true, StatusCode.OK, result);
    }


    /**
     * 方式三：面向对象的sql语句（JPQL）、hibernate（HQL）。
     *
     * @Query("select p from Person p where age = ?1")，其中Person是对象并非表名
     */
    @GetMapping(value = "/jpa3/queryPersons/{age}")
    public Message findByAgeAse(@PathVariable("age") Integer age) {
        List<Person> result = personService.findByAgeAse(age);
        return new Message(true, StatusCode.OK, result);
    }

    @GetMapping(value = "/jpa3/queryPersons/{age}/{currentPage}/{pageSize}")
    public Message findByAgeAseByPage(@PathVariable("age") Integer age, @PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize) {

        List<Person> result = personService.findByAgeAseByPage(age, currentPage, pageSize);
        return new Message(true, StatusCode.OK, result);
    }

    /**
     * 推荐方式四：原生态sql语句
     */
    @GetMapping(value = "/jpa4/findNameById/{id}")
    public Message findNameById(@PathVariable("id") String id) {
        String result = personService.findNameById(id);
        return new Message(true, StatusCode.OK, result);
    }

    @GetMapping(value = "/jpa4/findPersonByNameAndAge/{name}/{age}")
    public Message findPersonByNameAndAge(@PathVariable("name") String name, @PathVariable("age") int age) {
        List<Person> result = personService.findPersonByNameAndAge(name, age);
        return new Message(true, StatusCode.OK, result);
    }

    @GetMapping(value = "/jpa4/findPersonByAges/{currentPage}/{pageSize}")
    public Message findPersonByAges(@RequestParam("ages") List<Integer> ages,
                                     @PathVariable("currentPage") int currentPage,
                                     @PathVariable("pageSize") int pageSize) {
        List<Person> result = personService.findPersonByAges(ages, currentPage, pageSize);
        return new Message(true, StatusCode.OK, result);
    }

    @GetMapping(value = "/jpa4/findPersonByAges2/{currentPage}/{pageSize}")
    public Message findPersonByAges2(@RequestParam("ages") List<Integer> ages,
                                     @PathVariable("currentPage") int currentPage,
                                     @PathVariable("pageSize") int pageSize) {
        Page<Person> result = personService.findPersonByAges2(ages, currentPage, pageSize);
        return new Message(true, StatusCode.OK, result);
    }
}
