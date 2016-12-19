package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gimnasio.Pojo.EjerciciosRutina;
import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;
import com.gimnasio.Service.EjerciciosRutinaService;
import com.gimnasio.Service.RutinaService;
import com.gimnasio.Service.UsuarioService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EjerciciosRutinaService ejerciciosRutinaService;
	
	@Autowired
	private RutinaService rutinaService;
	
	@RequestMapping(value = "index")
	public String index(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioService.findByEmail(auth.getPrincipal().toString());
		model.addAttribute("usuario", usuario);
		try
		{
			Rutina rutina = rutinaService.findByUsuario(usuario.getId());
			model.addAttribute("rutina", rutina);
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaService.findByRutina(rutina.getId());
			model.addAttribute("ejerciciosRutina", ejerciciosRutina);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println(usuario);
		
		return "cliente/index";
	}
	
	@RequestMapping(value="/")
	public String vacio()
	{
		return "cliente/index";
	}

}
