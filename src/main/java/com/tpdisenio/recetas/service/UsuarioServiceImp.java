package com.tpdisenio.recetas.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpdisenio.recetas.dao.UsuarioDAO;
import com.tpdisenio.recetas.model.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

	private String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
/******************LA POSTA**********************/
private UsuarioDAO usuarioDAO;

public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
	this.usuarioDAO= usuarioDAO;
}



@Override
@Transactional
public void addUsuario(Usuario usr) {
	this.usuarioDAO.addUser(usr);
}

@Override
@Transactional
public void updateUsuario(Usuario usr) {
	this.usuarioDAO.updateUser(usr);
}

@Override
@Transactional
public List<Usuario> listUsuario() {
	return this.usuarioDAO.listUsers();
}

@Override
@Transactional
public Usuario getUsuarioById(String id_usr) {
	return this.usuarioDAO.getUserById(id_usr);
}

@Override
@Transactional
public void removeUsuario(String id_usr) {
	this.usuarioDAO.removeUser(id_usr);
}
	
	

	


	
	

}
