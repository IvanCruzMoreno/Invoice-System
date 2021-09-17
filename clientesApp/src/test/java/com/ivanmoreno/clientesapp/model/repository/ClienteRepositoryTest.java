package com.ivanmoreno.clientesapp.model.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ivanmoreno.clientesapp.model.entity.Cliente;

@DataJpaTest
class ClienteRepositoryTest {

	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Test
	void testFindById() {
		Optional<Cliente> cliente = clienteRepo.findById(1L);
		
		assertTrue(cliente.isPresent());
		assertEquals("Ivan", cliente.get().getNombre());
	}
	
	@Test
	void testFindByPersona() {
		Optional<Cliente> cuenta = clienteRepo.findById(1L);
		
		assertTrue(cuenta.isPresent());
		assertEquals("Ivan", cuenta.get().getNombre());
		assertEquals("Moreno", cuenta.get().getApellido());
	}
	
	@Test
	void testFindByPersonaThrowException() {
		Optional<Cliente> cuenta = clienteRepo.findById(15L);
		
//		assertThrows(NoSuchElementException.class, () -> cuenta.orElseThrow());
		assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
		assertFalse(cuenta.isPresent());
	}
	
	@Test
	void testFindAll() {
		List<Cliente> clientes = (List<Cliente>) clienteRepo.findAll();
		
		assertFalse(clientes.isEmpty());
		assertEquals(6, clientes.size());
	}
	
	@Test
	void testSave() {
		//Cliente cuentaPedro = new Cliente(null, "Pedro", "GG", "GG@gmail.com", new Date());
		Cliente cuentaPedro = Cliente.builder()
				.nombre("Pedro")
				.apellido("GG")
				.email("GG@gmail.com")
				.createAt(new Date())
				.build();
		
		Cliente cuentaSave = clienteRepo.save(cuentaPedro);
		
		Cliente cuenta = clienteRepo.findById(cuentaSave.getId()).orElseThrow();
		
		assertEquals("Pedro", cuenta.getNombre());
		assertEquals("GG@gmail.com", cuenta.getEmail());
	}
	
	@Test
	void testUpdate() {
		//Cliente cuentaPedro = new Cliente(null, "Pedro", "GG", "GG@gmail.com", new Date());
		Cliente cuentaPedro = Cliente.builder()
				.nombre("Pedro")
				.apellido("GG")
				.email("GG@gmail.com")
				.createAt(new Date())
				.build();
		
		Cliente cuenta = clienteRepo.save(cuentaPedro);
		
		assertEquals("Pedro", cuenta.getNombre());
		assertEquals("GG@gmail.com", cuenta.getEmail());
		
		cuenta.setApellido("FFF");
		cuenta = clienteRepo.save(cuenta);
		
		assertEquals("Pedro", cuenta.getNombre());
		assertEquals("FFF", cuenta.getApellido());
		
	}
	
	@Test
	void testDelete() {
		Cliente cuenta = clienteRepo.findById(2L).orElseThrow();
		
		assertEquals("carlos", cuenta.getNombre());
		
		clienteRepo.delete(cuenta);
		
		assertThrows(NoSuchElementException.class, () -> {
			clienteRepo.findById(2L).orElseThrow();
		});
		
	}
	
}
