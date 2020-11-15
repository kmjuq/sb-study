package com.study.sbmds.hpm.controller;

import com.study.sbmds.hpm.dao.ds2.PersonJpaRepository;
import com.study.sbmds.hpm.entity.ds2.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/10/23 15:45
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonJpaRepository personJpaRepository;
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(personJpaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        return ResponseEntity.ok(personJpaRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<List<Person>> addPerson(@RequestBody List<Person> persons){
        applicationContext.getBean(PersonController.class);
        return ResponseEntity.ok(personJpaRepository.saveAll(persons));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id){
        personJpaRepository.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return ResponseEntity.ok(personJpaRepository.save(person));
    }
}
