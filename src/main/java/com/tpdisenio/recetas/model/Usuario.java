package com.tpdisenio.recetas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value="session")
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	private String usuario;
	
	@Column(name="nombre_usuario")
	private String nombre;
	
	@Column(name="password_usuario")
	private String password;
	
	@Column(name="altura_usuario")
	private float altura;
	
	@Column(name="edad_usuario")
	private int edad;
	
	@Column(name="sexo_usuario")
	private char sexo;
	
	/*TODO*/
	@ManyToMany(targetEntity=Grupo.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="usuarioxgrupo",
	joinColumns={@JoinColumn(name="id_usuarioX")},inverseJoinColumns={@JoinColumn(name="id_grupoX")})
	private Set<Grupo> grupos;
	
	/*TODO*/	
	@ManyToMany(targetEntity=Condicion.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="condicionxusuario",
	joinColumns={@JoinColumn(name="id_usuarioX")},inverseJoinColumns={@JoinColumn(name="id_condicionX")})
	private Set<Condicion> condiciones;	
	
	
	
	public Set<Receta> getReceta() {
		return receta;
	}
	public void setReceta(Set<Receta> receta) {
		this.receta = receta;
	}
	/*TODO*/
	/*
	@OneToMany(mappedBy="usuario")
	private Set<Receta>receta;
	*/
	/*TODO*/
	@OneToMany(mappedBy="usuarioXX",cascade={CascadeType.ALL},fetch=FetchType.EAGER) //por definicion es lazy quiere decir que no levanta las recetas cuando levanto el usuario de la base de datos
	private Set<Receta>receta;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Set<Condicion> getCondiciones() {
		return condiciones;
	}
	public void setCondiciones(Set<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
	public Set<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	
}
