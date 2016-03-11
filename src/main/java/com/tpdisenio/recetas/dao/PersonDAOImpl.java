package com.tpdisenio.recetas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tpdisenio.recetas.model.Person;

@Repository

public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger= LoggerFactory.getLogger(PersonDAOImpl.class);
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public static Logger getLogger() {
		return logger;
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated succesfully, Person Details"+p);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List <Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::"+p);
		}		
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded succesfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details="+p);
	}

	
}
