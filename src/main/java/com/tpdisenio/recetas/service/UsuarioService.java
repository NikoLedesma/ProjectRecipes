package com.tpdisenio.recetas.service;

import java.util.List;

import com.tpdisenio.recetas.model.Usuario;

public interface UsuarioService {
	public void addUsuario(Usuario usr);
	public void updateUsuario(Usuario usr);
	public List<Usuario> listUsuario();
	public Usuario getUsuarioById(String id_usr);
	public void removeUsuario(String id_usr);
}
