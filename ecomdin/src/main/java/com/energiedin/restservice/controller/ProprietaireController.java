package com.energiedin.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energiedin.restservice.entity.Proprietaire;
import com.energiedin.restservice.repository.ProprietaireRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/proprietaires")
public class ProprietaireController {

    @Autowired
    private ProprietaireRepository repository;

    @GetMapping
    public Iterable<Proprietaire> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{email:.+}/")
    public Proprietaire find(@PathVariable("email") String email) {
    	System.out.println(email);
        return repository.findOne(email);
    }

    @PostMapping(consumes = "application/json")
    public Proprietaire create(@RequestBody Proprietaire user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable("email") String email) {
        repository.delete(email);
    }

    @PutMapping(path = "/{email}")
    public Proprietaire update(@PathVariable("email") String email, @RequestBody Proprietaire user) throws BadHttpRequest {
        if (repository.exists(email)) {
            user.setEmail(email);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }

}