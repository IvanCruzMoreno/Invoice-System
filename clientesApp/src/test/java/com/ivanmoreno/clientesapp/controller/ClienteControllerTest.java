package com.ivanmoreno.clientesapp.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanmoreno.clientesapp.dataTest.DatosTest;
import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.service.ClienteService;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClienteService clienteService;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void testIndex() throws Exception {
		List<Cliente> clientes = Arrays.asList(DatosTest.crearCliente001().orElseThrow(), 
				DatosTest.crearCliente002().orElseThrow(), DatosTest.crearCliente003().orElseThrow());
		
		when(clienteService.findAll()).thenReturn(clientes);
		
		mvc.perform(get("/api/clientes").contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].nombre").value("Ivan"))
		.andExpect(jsonPath("$[0].apellido").value("Moreno"))
		.andExpect(jsonPath("$[0].email").value("ivanmoreno@gmail.com"))
		.andExpect(jsonPath("$", Matchers.hasSize(3)));
	}
	
	@Test
	void testShow() throws Exception {
		
		when(clienteService.findById(1L)).thenReturn(DatosTest.crearCliente001().orElseThrow());
		
		mvc.perform(get("/api/clientes/1").contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.nombre").value("Ivan"))
		.andExpect(jsonPath("$.apellido").value("Moreno"));
	}
	
	@Test
	void testCreate() throws Exception {
		Cliente cliente = Cliente.builder()
									.nombre("Pepe")
									.apellido("PP")
									.email("pp@gmail.com")
									.build();
		
		when(clienteService.save(any())).then(invocation -> {
			Cliente c = invocation.getArgument(0);
			c.setId(11L);
			return c;
		});
		
		mvc.perform(post("/api/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente)))
		
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.cliente.nombre").value("Pepe"))
		.andExpect(jsonPath("$.cliente.apellido").value("PP"))
		.andExpect(jsonPath("$.cliente.id").value("11"));
	}
	
	@Test
	void testUpdate() throws Exception {
		Cliente cliente = Cliente.builder()
				.id(15L)
				.nombre("Pepe")
				.apellido("PP")
				.email("pp@gmail.com")
				.build();
										
		when(clienteService.findById(1L)).thenReturn(DatosTest.crearCliente001().orElseThrow());
		when(clienteService.save(any())).then(invocation -> invocation.getArgument(0));
		
		mvc.perform(put("/api/clientes/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cliente)))
		
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.cliente.nombre").value("Pepe"))
		.andExpect(jsonPath("$.cliente.id").value("1"))
		.andExpect(jsonPath("$.cliente.apellido").value("PP"))
		.andExpect(jsonPath("$.cliente.email").value("pp@gmail.com"));
		
	}
	
	@Test
	void testDelete() throws Exception {
							
		mvc.perform(delete("/api/clientes/1")
				.contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.mensaje").value("El cliente eliminado con exito"));
		
	}
}


















