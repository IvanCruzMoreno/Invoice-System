package com.ivanmoreno.clientesapp.model.repository.autorizacion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ivanmoreno.clientesapp.model.entity.autorizacion.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.username=?1" )
	public Usuario findByUsername(String username);
}
