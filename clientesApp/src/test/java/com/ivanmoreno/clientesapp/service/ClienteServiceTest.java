package com.ivanmoreno.clientesapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ivanmoreno.clientesapp.dataTest.DatosTest;
import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.repository.ClienteRepository;

@SpringBootTest
class ClienteServiceTest {

	@MockBean
	ClienteRepository clienteRepo;
	
	@Autowired
	ClienteService clienteService;
	
	@Test
	void testFindAll() {
		
		List<Cliente> clientesTest = Arrays.asList(DatosTest.crearCliente001().orElseThrow(), 
				DatosTest.crearCliente002().orElseThrow(), DatosTest.crearCliente003().orElseThrow());
		
		when(clienteRepo.findAll()).thenReturn(clientesTest);
		
		List<Cliente> clientes = clienteService.findAll();
		
		assertFalse(clientes.isEmpty());
		assertEquals(3, clientes.size());
		assertTrue(clientes.contains(DatosTest.crearCliente002().orElseThrow()));
		
		verify(clienteRepo).findAll();
	}
	
	@Test
	void testFindById() {
		when(clienteRepo.findById(1L)).thenReturn(DatosTest.crearCliente001());
		
		Cliente cliente = clienteService.findById(1L);
		
		assertEquals(1L, cliente.getId());
		assertFalse("Carlos".equals(cliente.getNombre()));
	}
	
	@Test
	void testSave() {
		
		Cliente newCliente = new Cliente(null, "Lil x", "Mu", "lilx@gmail.com", new Date());
		
		when(clienteRepo.save(any())).then(invocation -> {
			Cliente cliente = invocation.getArgument(0);
			cliente.setId(15L);
			return cliente;
		});
		
		Cliente cliente = clienteService.save(newCliente);
		
		assertEquals("Lil x", cliente.getNombre());
		assertEquals("Mu", cliente.getApellido());
		assertEquals("lilx@gmail.com", cliente.getEmail());
		
		verify(clienteRepo).save(any());
	}

}
