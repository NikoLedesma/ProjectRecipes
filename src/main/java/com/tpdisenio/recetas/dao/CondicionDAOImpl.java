package com.tpdisenio.recetas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tpdisenio.recetas.model.Condicion;

public class CondicionDAOImpl implements CondicionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CondicionDAOImpl.class);
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Condicion> listCondiciones() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Condicion> condicionList = session.createQuery("from Condicion").list();
		for (Condicion condicion : condicionList) {
			logger.info("Condicion List::" + condicion.getId_nombre());
		}
		return condicionList;
	}
	
	@Override
	public Condicion getCondicionById(String id_condicion) {
		Session session = this.sessionFactory.getCurrentSession();
		Condicion condicion =(Condicion) session.load(Condicion.class, new String(id_condicion));
		logger.info("Condicion loaded succesfully,Condicion details=" + condicion.getId_nombre());
		return condicion;
	}

}
