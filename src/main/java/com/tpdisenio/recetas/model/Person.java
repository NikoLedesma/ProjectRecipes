package com.tpdisenio.recetas.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
@Entity
@Table(name="PERSON")
public class Person {

@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

/*
 * notice that I have not annotated “name” and 
 * “country” fields with @Column annotation
 *  because they are of same name. 
 * Below SQL script shows the table details.
 * */

//@Column(name="name") descomentar
private String name;

//@Column(name="country")descomentar
private String country;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}
	
public String toString(){
	return "id="+id+", name="+name+", country="+country;
}

}
