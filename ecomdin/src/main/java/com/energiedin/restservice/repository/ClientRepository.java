package com.energiedin.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.energiedin.restservice.entity.Client;

@RestResource(exported = false)
public interface ClientRepository extends JpaRepository<Client, String> {

}