package com.tpdisenio.recetas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpdisenio.recetas.bean.RecetaBean;
import com.tpdisenio.recetas.model.Usuario;




@Controller
@Scope(value="request")
public class RecetaController {
	@Autowired
	private Usuario usuario;//tmp puedo acceder desde el jsp obteniendo la sessio y haciendo un 
	//getAttribute("usuario") y se podria eliminar el private Usuario y el modelo add ("usuario",usuario)
	@RequestMapping( value="recetasPersonales")
	public String crearReceta(Model modelo){
		RecetaBean recetaBean=new RecetaBean();
		//recetaBean.setUsuario();
		modelo.addAttribute("recetaBean",recetaBean);		
		String a= "pepe";
		String b= "luis";
		String c= "alberto";
		List<String> l = new ArrayList<String>();
		l.add(a);
		l.add(b);
		l.add(c);
		modelo.addAttribute("calAux",RecetaBean.getCalificaciones());
		modelo.addAttribute("lista",l);
		modelo.addAttribute("usuario", usuario);
		return "receta";
	}
	
}
