package com.tpdisenio.recetas.dao;

import java.util.List;

import com.tpdisenio.recetas.model.Condicion;


public interface CondicionDAO {
//	public void addCondicion(Condicion c);
//	public void updateCondicion(Condicion c);
	public List<Condicion> listCondiciones();
	public Condicion getCondicionById(String id_condicion);
//	public void removeCondicion(int id);	
}
