package com.ivanmoreno.clientesapp.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // generates getters, setters, equals, toString & hashCode we well
@Builder // generates builder for the fields within
@NoArgsConstructor // generates a no argument constructor
@AllArgsConstructor // generates a constructor with all arguments
@ToString // generates toString method, skipping passed field as name
@EqualsAndHashCode(exclude = {"createAt"}) // generates equals and hashCode methods, skipping passed fields
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	private String apellido;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	
	private static final long serialVersionUID = 1L;
}
