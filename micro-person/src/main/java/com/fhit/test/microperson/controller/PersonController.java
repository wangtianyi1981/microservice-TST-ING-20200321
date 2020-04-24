package com.fhit.test.microperson.controller;

import com.fhit.test.microcommon.entity.Message;
import com.fhit.test.microcommon.entity.StatusCode;
import com.fhit.test.microperson.entity.Person;
import com.fhit.test.microperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wty
 * @create 2020-04-18 21:39
 */
@RestController
//@RequestMapping(value = "Person")
public class PersonController {
    @Autowired
    PersonService personService;

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
}
