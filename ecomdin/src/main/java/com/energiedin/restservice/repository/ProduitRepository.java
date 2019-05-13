package com.energiedin.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.energiedin.restservice.entity.Produit;

@RestResource(exported = false)
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}