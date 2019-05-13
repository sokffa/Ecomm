package com.energiedin.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.energiedin.restservice.entity.Commande;

@RestResource(exported = false)
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}