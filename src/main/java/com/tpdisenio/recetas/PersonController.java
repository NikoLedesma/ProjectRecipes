package com.tpdisenio.recetas;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tpdisenio.recetas.model.LoginForm;
import com.tpdisenio.recetas.model.Person;
import com.tpdisenio.recetas.service.PersonService;

@Controller
public class PersonController {
	
	
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService=ps;
	}
	
	@RequestMapping(value="/persons", method = RequestMethod.GET)
	public String listPersons(Model model){
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons",this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value="/person/add",method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		if(p.getId()==0){
			this.personService.addPerson(p);
		}else{
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}
	
	@RequestMapping("/remove/{id}")
	public String removePerson (@PathVariable("id") int id){
		this.personService.removePerson(id);
		return "redirect:/persons";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPerson (@PathVariable("id")int id,Model model){
		model.addAttribute("person",this.personService.getPersonById(id));
		model.addAttribute("listPersons",this.personService.listPersons());
		return "person";
	}
	
		
	@RequestMapping("logout/{id}")
	public String logoutUser(HttpServletRequest req,Model model,@PathVariable(value="id") int id)
	{	
		model.addAttribute("login", new LoginForm());
		HttpSession session=req.getSession();
		session.invalidate();
		return "login";
	} 
	
	
	
}
