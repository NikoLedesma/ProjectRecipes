package com.tpdisenio.recetas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tpdisenio.recetas.model.Usuario;


@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	private static final Logger logger= LoggerFactory.getLogger(PersonDAOImpl.class);
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	
	@Override
	public void addUser(Usuario usr) {
		Session session=this.sessionFactory.getCurrentSession();
		//session.persist(usr); TODO: el persist es parecido al save pero no al saveOrUpdate(este me permite crear un objeto y si ya existe no hay problema)
		session.saveOrUpdate(usr);
		logger.info("Person saved successfully, Person Details="+usr.getNombre());
	}

	@Override
	public void updateUser(Usuario usr) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(usr);
		logger.info("Person updated succesfully, Person Details"+usr.getNombre());

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List <Usuario> usersList = session.createQuery("from Usuario").list();
		for (Usuario usuario : usersList) {
			logger.info("User List::"+usuario.getUsuario());
		}
		return usersList;
	}

	@Override
	public Usuario getUserById(String id_usr) {
		Session session=this.sessionFactory.getCurrentSession();
		Usuario usr= (Usuario) session.load(Usuario.class, new String(id_usr));
	    logger.info("User loaded succesfully,User details="+usr.getNombre()); 
		return usr;
	}

	@Override
	public void removeUser(String id_usr) {
		Session session=this.sessionFactory.getCurrentSession();
		Usuario usr=(Usuario) session.load(Usuario.class, id_usr);
		if(null != usr){
            session.delete(usr);
        }
		logger.info("Person deleted succesfully, user details="+usr.getUsuario());
	}

}
