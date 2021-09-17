package com.ivanmoreno.clientesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	 @PutMapping("/clientes/{id}")
	 @ResponseStatus(HttpStatus.CREATED)
	 public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		 
		 Cliente clienteDB = clienteService.findById(id);
		 
		 clienteDB.setNombre(cliente.getNombre());
		 clienteDB.setApellido(cliente.getApellido());
		 clienteDB.setEmail(cliente.getEmail());
		 
		 return clienteService.save(clienteDB);
	 }
	 
	 @DeleteMapping("/clientes/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable Long id) {
		 clienteService.delete(id);
	 }
	 
}
