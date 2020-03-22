package com.fhit.test.microperson.service;

import com.fhit.test.microperson.dao.PersonDao;
import com.fhit.test.microperson.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
