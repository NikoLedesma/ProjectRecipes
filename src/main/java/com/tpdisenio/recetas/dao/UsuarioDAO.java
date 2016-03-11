package com.tpdisenio.recetas.dao;

import java.util.List;

import com.tpdisenio.recetas.model.Usuario;


public interface UsuarioDAO {
	public void addUser(Usuario usr);
	public void updateUser(Usuario usr);
	public List<Usuario> listUsers();
	public Usuario getUserById(String id_usr);
	public void removeUser(String id_usr);	
}
