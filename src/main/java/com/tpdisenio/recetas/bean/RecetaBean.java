package com.tpdisenio.recetas.bean;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecetaBean {

	private int id;
	private String nombre;
	private String explicacion;
	private char calificacion;
	private static Map<String, String> calificaciones;
	static {
		calificaciones = new LinkedHashMap<String, String>();
		calificaciones.put("a", "1(no me gusta)");
		calificaciones.put("b", "2(no me gusta mucho)");
		calificaciones.put("c", "3(me gusta poco)");
		calificaciones.put("d", "4(me gusta)");
		calificaciones.put("e", "5(me encanta)");
	}

	// private String nombre_usuario;
	// private String nombre_grupo;

	public static Map<String, String> getCalificaciones() {
		return calificaciones;
	}

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

	public char getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(char calificacion) {
		this.calificacion = calificacion;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

}
