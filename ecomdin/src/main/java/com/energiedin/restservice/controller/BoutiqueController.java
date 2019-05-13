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

import com.energiedin.restservice.entity.Boutique;
import com.energiedin.restservice.repository.BoutiqueRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/boutique")
public class BoutiqueController {

    @Autowired
    private BoutiqueRepository repository;

    @GetMapping
    public Iterable<Boutique> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{nom}")
    public Boutique find(@PathVariable("nom") String nom) {
        return repository.findOne(nom);
    }

    @PostMapping(consumes = "application/json")
    public Boutique create(@RequestBody Boutique user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{nom}")
    public void delete(@PathVariable("nom") String nom) {
        repository.delete(nom);
    }

    @PutMapping(path = "/{nom}")
    public Boutique update(@PathVariable("nom") String nom, @RequestBody Boutique boutique) throws BadHttpRequest {
        if (repository.exists(nom)) {
        	boutique.setNom(nom);
            return repository.save(boutique);
        } else {
            throw new BadHttpRequest();
        }
    }

}