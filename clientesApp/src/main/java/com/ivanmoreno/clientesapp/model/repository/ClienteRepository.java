package com.ivanmoreno.clientesapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanmoreno.clientesapp.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
}
