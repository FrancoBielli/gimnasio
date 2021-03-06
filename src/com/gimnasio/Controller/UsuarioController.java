package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;
import com.gimnasio.Pojo.Valid.SpringFormGroup;
import com.gimnasio.Service.EvolucionUsuarioService;
import com.gimnasio.Service.RutinaService;
import com.gimnasio.Service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RutinaService rutinaService;
	
	@Autowired
	private EvolucionUsuarioService evolucionUsuarioService;
	
	@RequestMapping(value ="/")
	public String vacio()
	{
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "index")
	public String usuarioIndex(Model model)
	{
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuario/index";
	}

	@RequestMapping(value="crear", method = RequestMethod.GET)
	public String verCrearUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/crear";
	}
	
	
	
	@RequestMapping(value = "{id}/editar", method = RequestMethod.GET)
	public String verEditarUsuario(Model model, @PathVariable("id") int id)
	{
		try
		{
			Usuario usuario = usuarioService.findById(id);
			model.addAttribute("usuario", usuario);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "usuario/editar";
	}
	
	@RequestMapping(value = "{id}/detalle", method = RequestMethod.GET)
	public String detalleUsuario(Model model, @PathVariable("id") int id)
	{
		try
		{
			Usuario usuario = usuarioService.findById(id);
			model.addAttribute("usuario", usuario);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "usuario/detalles";
	}
	
	@RequestMapping(value="crearUsuario", method = RequestMethod.POST)
	public String crearUsuario(@ModelAttribute("usuario") @Validated(value=SpringFormGroup.class) Usuario usuario, 
			BindingResult result, Model model){
		if(!result.hasErrors())
		{
			try
			{
				usuario.setActivo(true);
				usuarioService.saveOrUpdate(usuario);
				return "redirect:index";
				
			}
			catch(Exception e)
			{
				System.out.print(e.toString());
			}
			return "redirect:index";
		}
		return "usuario/crear";
	}
	
	@RequestMapping(value ="editarUsuario", method = RequestMethod.POST)
	public String editarUsuario(Model model, @ModelAttribute("usuario") @Validated(value=SpringFormGroup.class) Usuario usuario, BindingResult result)
	{
		if(!result.hasErrors())
		{
			try
			{
				usuarioService.saveOrUpdate(usuario);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			return "redirect:index";
		}
		return "usuario/editar";
		
	}
	
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.GET)
	public String eliminarUsuario(Model model,@PathVariable("id") int id)
	{
		Usuario usuario = usuarioService.findById(id);
		evolucionUsuarioService.deleteByUsuario(usuario);
		usuarioService.delete(usuario);
		return "redirect:/usuario/index";
	}
	
	@RequestMapping(value = "{id}/asignarRutina", method = RequestMethod.GET)
	public String verAsignarRutina(Model model, @PathVariable("id") int id)
	{
		try
		{
			Usuario usuario = usuarioService.findById(id);
			List<Rutina> rutinas = rutinaService.findAll();
			model.addAttribute("usuario", usuario);
			model.addAttribute("rutinas", rutinas);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "usuario/asignarRutina";
	}
	
	@RequestMapping(value ="asignarRutina", method = RequestMethod.POST)
	public String asignarRutina(Model model, @ModelAttribute("usuario") Usuario usuario)
	{
		try
		{
			Rutina rutina = rutinaService.findById(usuario.getRutina().getId());
			usuario = usuarioService.findById(usuario.getId());
			usuarioService.updateRutina(usuario, rutina);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			usuarioService.updateRutina(usuario, null);
		}
		
		return "redirect:index";
	}
	
}
