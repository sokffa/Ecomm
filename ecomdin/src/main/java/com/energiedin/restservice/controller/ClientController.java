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

import com.energiedin.restservice.entity.Client;
import com.energiedin.restservice.repository.ClientRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{email:.+}/")
    public Client find(@PathVariable("email") String email) {
    	System.out.println(email);
        return repository.findOne(email);
    }

    @PostMapping(consumes = "application/json")
    public Client create(@RequestBody Client user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable("email") String email) {
        repository.delete(email);
    }

    @PutMapping(path = "/{email}")
    public Client update(@PathVariable("email") String email, @RequestBody Client user) throws BadHttpRequest {
        if (repository.exists(email)) {
            user.setEmail(email);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }

}