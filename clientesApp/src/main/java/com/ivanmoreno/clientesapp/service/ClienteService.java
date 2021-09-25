package com.ivanmoreno.clientesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.entity.Region;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
}
