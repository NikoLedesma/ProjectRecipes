package com.tpdisenio.recetas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="condicion")
public class Condicion {
	
	@Id
	@Column(name="id_condicion")
	private String id_nombre;

	public String getId_nombre() {
		return id_nombre;
	}

	public void setId_nombre(String id_nombre) {
		this.id_nombre = id_nombre;
	}

}
