package com.tpdisenio.recetas.bean;

import java.util.List;


public class UsuarioBean {

	private String usuario;
	
	private String nombre;
	
	private String password;
	
	private float altura;
	
	private int edad;
	
	private char sexo;

	private List <String> condiciones;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<String> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<String> condiciones) {
		this.condiciones = condiciones;
	}
	
	
	
	
}
