package com.ivanmoreno.clientesapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepo;
	
	public ClienteServiceImpl(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepo.deleteById(id);
	}

	
}
