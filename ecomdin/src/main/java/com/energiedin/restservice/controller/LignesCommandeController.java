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

import com.energiedin.restservice.entity.LignesCommande;
import com.energiedin.restservice.repository.LignesCommandeRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/lignesCommandes")
public class LignesCommandeController {

    @Autowired
    private LignesCommandeRepository repository;

    @GetMapping
    public Iterable<LignesCommande> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public LignesCommande find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public LignesCommande create(@RequestBody LignesCommande lignesCommande) {
    	return repository.save(lignesCommande);
    }

 

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public LignesCommande update(@PathVariable("id") int id, @RequestBody LignesCommande lignesCommande) throws BadHttpRequest {
        if (repository.exists(id)) {
            lignesCommande.setId(id);
            return repository.save(lignesCommande);
        } else {
            throw new BadHttpRequest();
        }
    }

}