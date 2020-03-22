package com.fhit.test.microperson2.service;

import com.fhit.test.microperson2.dao.PersonDao;
import com.fhit.test.microperson2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public List<Person> findByNameOrderByAgeDesc(String name) {
        return personDao.findByNameOrderByAgeDesc(name);
    }

    public List<Person> findByAgeAse(Integer age) {
        return personDao.findByAgeAse(age);
    }

    public List<Person> findByAgeAseByPage(Integer age, int currentPage, int pageSize) {
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);
        return personDao.findByAgeAseByPage(age, pageable);
    }

    @Transactional
    public int updatePerson(Integer id) {
        return personDao.updatePerson(id);
    }

    @Transactional
    public int updatePerson2(Integer id, Person person) {
        return personDao.updatePerson2(id, person);
    }
}
