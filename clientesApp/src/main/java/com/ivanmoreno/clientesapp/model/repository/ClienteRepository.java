package com.ivanmoreno.clientesapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.entity.Region;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select r from Region r")
	public List<Region> findAllRegiones();
}
