package com.tpdisenio.recetas.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="receta")
public class Receta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_receta")
	private int id;
	
	@Column(name="nombre_receta")
	private String nombre;
	
	@Column(name="explicacion_receta")
	private String explicacion;
	
	@Column(name="calificacion_receta")
	private char calificacion;
	
	
	@ManyToOne
	@JoinColumn(name="usuario_id_fk",nullable=false)
	private Usuario usuarioXX;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public char getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(char calificacion) {
		this.calificacion = calificacion;
	}

	public Usuario getUsuarioXX() {
		return usuarioXX;
	}

	public void setUsuarioXX(Usuario usuarioXX) {
		this.usuarioXX = usuarioXX;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Column(name="grupo_id_fk")
	private String grupo;
	
	
	
	/*@ManyToMany(targetEntity=Condimento.class,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="condicionxusuario",joinColumns={@JoinColumn(name="id_recetax")},inverseJoinColumns={@JoinColumn(name="id_condimentox")})
	private Set<Condimento> condimentos;
	*/
	
}
