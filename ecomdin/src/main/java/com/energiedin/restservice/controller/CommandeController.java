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

import com.energiedin.restservice.entity.Commande;
import com.energiedin.restservice.repository.CommandeRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/commandes")
public class CommandeController {

    @Autowired
    private CommandeRepository repository;

    @GetMapping
    public Iterable<Commande> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Commande find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Commande create(@RequestBody Commande commande) {
    	return repository.save(commande);
    }

 

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Commande update(@PathVariable("id") int id, @RequestBody Commande commande) throws BadHttpRequest {
        if (repository.exists(id)) {
        	commande.setId(id);
            return repository.save(commande);
        } else {
            throw new BadHttpRequest();
        }
    }

}