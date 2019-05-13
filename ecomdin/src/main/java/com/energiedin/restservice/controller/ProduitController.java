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

import com.energiedin.restservice.entity.Produit;
import com.energiedin.restservice.repository.ProduitRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository repository;

    @GetMapping
    public Iterable<Produit> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Produit find(@PathVariable("id") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Produit create(@RequestBody Produit produit) {
    	return repository.save(produit);
    }

 

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Produit update(@PathVariable("id") int id, @RequestBody Produit produit) throws BadHttpRequest {
        if (repository.exists(id)) {
        	produit.setId(id);
            return repository.save(produit);
        } else {
            throw new BadHttpRequest();
        }
    }

}