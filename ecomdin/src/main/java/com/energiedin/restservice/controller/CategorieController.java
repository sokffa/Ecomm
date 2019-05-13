package com.energiedin.restservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energiedin.restservice.entity.Categorie;
import com.energiedin.restservice.repository.CategorieRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/categories")
public class CategorieController {
	
    @Autowired
    private CategorieRepository repository;

    @GetMapping
    public Iterable<Categorie> findAll() {
    	List<Categorie> list =  repository.findAll();
    	List<Categorie> l = new ArrayList<>();
    	for (int i =0 ; i<list.size() ; i++) {    		
    		if(list.get(i).getParent()==null)
    			l.add(list.get(i));
    	}
    	return l;
    }

    @GetMapping(path = "/{id}")
    public Categorie find(@PathVariable("nom") int id) {
        return repository.findOne(id);
    }

    @PostMapping(consumes = "application/json")
    public Categorie create(@RequestBody Categorie categorie) {
        return repository.save(categorie);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{id}")
    public Categorie update(@PathVariable("id") int id, @RequestBody Categorie categorie) throws BadHttpRequest {
        if (repository.exists(id)) {
        	categorie.setId(id );
            return repository.save(categorie);
        } else {
            throw new BadHttpRequest();
        }
    }

}