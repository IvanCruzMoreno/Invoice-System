package com.ivanmoreno.clientesapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ivanmoreno.clientesapp.model.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByName(String name);
}
