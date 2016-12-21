package com.gimnasio.Controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gimnasio.Pojo.EvolucionUsuario;
import com.gimnasio.Pojo.Usuario;
import com.gimnasio.Service.EvolucionUsuarioService;
import com.gimnasio.Service.UsuarioService;

@Controller
@RequestMapping(value="/evolucionUsuario")
public class EvolucionUsuarioController {

	@Autowired
	private EvolucionUsuarioService evolucionUsuarioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/")
	public String vacio()
	{
		return "redirect:index";
	}
	
	@RequestMapping(value="{id}/index", method = RequestMethod.GET)
	public String index(Model model, @PathVariable("id") int id)
	{
		Usuario usuario = usuarioService.findById(id);
		List<EvolucionUsuario> evolucionDeUsuario = evolucionUsuarioService.listByUsuario(id);
		model.addAttribute("evolucionDeUsuario", evolucionDeUsuario);
		model.addAttribute("usuario", usuario);
		return "evolucionUsuario/index";
	}
	
	@RequestMapping(value="{id}/crear", method = RequestMethod.GET)
	public String verCrearEvolucionUsuario(Model model, @PathVariable("id") int id) {
		model.addAttribute("evolucionUsuario", new EvolucionUsuario());
		model.addAttribute("usuario", usuarioService.findById(id));
		return "evolucionUsuario/crear";
	}
	
	@RequestMapping(value="crearEvolucionUsuario", method = RequestMethod.POST)
	public String crearEvolucionUsuario(@ModelAttribute("evolucionUsuario") @Valid EvolucionUsuario evolucionUsuario,
			BindingResult result,
			Model model ){
		if(!result.hasErrors())
		{
			try
			{
				evolucionUsuario.setFecha(new Timestamp(new Date().getTime()));
				evolucionUsuarioService.saveOrUpdate(evolucionUsuario);
			}
			catch(Exception e)
			{
				System.out.print(e.toString());
			}		
			
			return "redirect:" + evolucionUsuario.getUsuario().getId() +"/index";
		}
		return "evolucionUsuario/crear";
	}
	
	@RequestMapping(value = "{id}/editar", method = RequestMethod.GET)
	public String verEditarEvolucionUsuario(Model model, @PathVariable("id") int id)
	{
		try
		{
			EvolucionUsuario evolucionUsuario = evolucionUsuarioService.findById(id);
			model.addAttribute("evolucionUsuario", evolucionUsuario);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "evolucionUsuario/editar";
	}
	
	@RequestMapping(value ="editarEvolucionUsuario", method = RequestMethod.POST)
	public String editarRutina(Model model, 
			@ModelAttribute("evolucionUsuario") @Valid EvolucionUsuario evolucionUsuario,
			BindingResult result)
	{
		if(!result.hasErrors())
		{
			try
			{
				evolucionUsuarioService.saveOrUpdate(evolucionUsuario);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			return "redirect:"+ evolucionUsuario.getUsuario().getId() +"/index";
		}
		return "evolucionUsuario/editar";
	}
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.GET)
	public String eliminarEvolucionUsuario(Model model,@PathVariable("id") int id)
	{
		EvolucionUsuario evolucionUsuario = evolucionUsuarioService.findById(id);
		evolucionUsuarioService.delete(evolucionUsuario);
		id = evolucionUsuario.getUsuario().getId();
		return "redirect:/evolucionUsuario/" + id + "/index";
	}
}
