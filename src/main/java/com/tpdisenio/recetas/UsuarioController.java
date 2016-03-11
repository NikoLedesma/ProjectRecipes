package com.tpdisenio.recetas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpdisenio.recetas.bean.UsuarioBean;
import com.tpdisenio.recetas.model.Condicion;
import com.tpdisenio.recetas.model.Usuario;
import com.tpdisenio.recetas.service.UsuarioService;


@Controller
public class UsuarioController {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	private UsuarioService usuarioService;

	@Autowired(required = true)
	@Qualifier(value = "usuarioService")
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	@RequestMapping(value = "registracion")
	public String addUser(Model model,@ModelAttribute("usuarioBean") UsuarioBean usuarioBean) {
		Usuario usr=crearUsuario(usuarioBean);
		//TODO : validar que el usuario no exista con ajax
		
		usuarioService.addUsuario(usr);
		return "redirect:?reg=43";
	}

	
	@RequestMapping(value = "/registro")
	public String comandante(Model model) {
		model.addAttribute("usuarioBean", new UsuarioBean());
		return "registration";
	}

	private Usuario crearUsuario(UsuarioBean usuarioBean) {
		Usuario usuario = new Usuario();
		usuario.setNombre(usuarioBean.getNombre());
		usuario.setUsuario(usuarioBean.getUsuario());
		usuario.setAltura(usuarioBean.getAltura());		
		usuario.setSexo(usuarioBean.getSexo());
		usuario.setPassword(usuarioBean.getPassword());
		Set<Condicion> condicionesPosta = new HashSet<Condicion>();
		List<String> condiciones = usuarioBean.getCondiciones();
		if (condiciones != null) {
			for (String condicion : condiciones) {
				System.out.println("Condicion agregada:" + condicion);
				Condicion nuevaCondicion = new Condicion();
				nuevaCondicion.setId_nombre(condicion);
				condicionesPosta.add(nuevaCondicion);
			}
		}
		usuario.setCondiciones(condicionesPosta);
		return usuario;
	}
	
}
