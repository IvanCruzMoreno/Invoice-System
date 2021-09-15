package com.ivanmoreno.clientesapp.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ivanmoreno.clientesapp.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	
}
