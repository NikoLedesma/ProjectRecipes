package com.tpdisenio.recetas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tpdisenio.recetas.bean.AuxBean;
import com.tpdisenio.recetas.bean.UsuarioBean;
import com.tpdisenio.recetas.dao.PersonDAOImpl;
import com.tpdisenio.recetas.model.Condicion;
import com.tpdisenio.recetas.model.Grupo;
import com.tpdisenio.recetas.model.LoginForm;
import com.tpdisenio.recetas.model.Usuario;
import com.tpdisenio.recetas.service.UsuarioService;

@Controller
@Scope(value="session")
public class HomeController {

	private Usuario usuario;
	/* al hacer autowired se inyecta el usuario por lo cual en este caso es del 
	 * tipo session y no tengo que perder la referencia por lo cual no puedo hacer
	 *  usuario=new Usuario() ya que pierdo referencia al puntero del objeto
	 *   declarado como variable de session--->debo setearle los valores*/
		
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	private UsuarioService usuarioService;

	@Autowired(required = true)
	@Qualifier(value = "usuarioService")
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value = "/")
	public String redirectionToLog(Model model,HttpServletRequest req) {
		model.addAttribute("login", new LoginForm());
	
		
		HttpSession session=req.getSession();
		
	System.out.println("Id session:"+session.getId());
		if(session.isNew()){
			
			System.out.println("New session is jutst created"+session.getId());
		}else{
			System.out.println("This is old session"+session.getId());
			session.invalidate();
			System.out.println("I erased an session"+session.getId());
		}		
			
		return "login";
	}

	@RequestMapping(value = "menu")
	public/* String */ModelAndView irAlMenu(
	/* Model model, */@ModelAttribute("login") LoginForm lp,HttpServletRequest req) {
		
		
		 HttpSession session = req.getSession();
		
		 Usuario uSession = (Usuario) session.getAttribute("usuario");
		 if( uSession == null ){
			 logger.info("Ingreso-->Usuario:" +lp.getUser() + "  Password:"+ lp.getPassword()); 
			 logger.info("Session Id:"+session.getId()); 	
				usuario=new Usuario();
			 	setUsuarioOfSession( lp );
				session.setAttribute("usuario", usuario);
		 }
		 else{
			 usuario=uSession;
			 logger.info("Usuario ya inicio session Ingreso-->Usuario:" + uSession.getUsuario() + "  Password:"+ uSession.getPassword()); 	 
			 logger.info("Session Id:"+session.getId()); 	
		 }
		

		 
		 
		ModelAndView mav = new ModelAndView("main");
		Map<String, String> grupos = new HashMap<String, String>();
		Set<Grupo> g = usuario.getGrupos();
		for (Grupo grupo : g) {
			grupos.put(grupo.getGrupo(), grupo.getGrupo().toUpperCase());
		}
		mav.addObject("gruposMap", grupos);
		//mav.addObject("mensajeDelServiceHome", "holaaa");
		mav.addObject("auxBean", new AuxBean());
		mav.addObject("usuario",usuario);
	
		return /* "main" */mav;
	}
	/*se setea los valores de usuario que se inyecto como variable de session*/
	public void setUsuarioOfSession(LoginForm lp ){
		Usuario x = usuarioService.getUsuarioById(lp.getUser());
		usuario.setUsuario(x.getUsuario());
		usuario.setNombre(x.getNombre());
		usuario.setCondiciones(x.getCondiciones());
		usuario.setEdad(x.getEdad());
		usuario.setGrupos(x.getGrupos());
		usuario.setAltura(x.getAltura());
		usuario.setSexo(x.getSexo());
		usuario.setPassword(x.getPassword());
		usuario.setReceta(x.getReceta());//TODO
	}
	
	
	
	
	
	
}













