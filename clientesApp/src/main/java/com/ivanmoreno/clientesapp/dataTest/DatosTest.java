package com.ivanmoreno.clientesapp.dataTest;

import java.util.Date;
import java.util.Optional;

import com.ivanmoreno.clientesapp.model.entity.Cliente;
import com.ivanmoreno.clientesapp.model.entity.Region;

public class DatosTest {

	public static Optional<Cliente> crearCliente001() {
		return Optional.of(Cliente.builder()
									.id(1L)
									.nombre("Ivan")
									.apellido("Moreno")
									.email("ivanmoreno@gmail.com")
									.createAt(new Date())
									.region(new Region(1L, "centroamerica"))
									.build());
	}
	
	public static Optional<Cliente> crearCliente002() {
		return Optional.of(Cliente.builder()
									.id(2L)
									.nombre("carlos")
									.apellido("Moreno")
									.email("carlos@gmail.com")
									.createAt(new Date())
									.region(new Region(2L, "norteamerica"))
									.build());
	}
	
	public static Optional<Cliente> crearCliente003() {
		return Optional.of(Cliente.builder()
									.id(3L)
									.nombre("Cruz")
									.apellido("Wood")
									.email("woodCruz@gmail.com")
									.createAt(new Date())
									.region(new Region(3L, "sudaamerica"))
									.build());
	}
}
