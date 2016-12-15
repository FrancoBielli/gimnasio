package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Service.RutinaService;

@Controller
@RequestMapping(value="/rutina")
public class RutinaController {
	
	@Autowired
	private RutinaService rutinaService;
	
	@RequestMapping(value ="/")
	public String vacio()
	{
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "index")
	public String rutinaIndex(Model model)
	{
		List<Rutina> rutinas= rutinaService.findAll();
		model.addAttribute("rutinas", rutinas);
		return "rutina/index";
	}
	
	@RequestMapping(value="crear", method = RequestMethod.GET)
	public String verCrearRutina(Model model) {
		model.addAttribute("rutina", new Rutina());
		return "rutina/crear";
	}
	
	@RequestMapping(value="crearRutina", method = RequestMethod.POST)
	public String crearRutina(@ModelAttribute("rutina") Rutina rutina, Model model ){
		try
		{
			rutinaService.saveOrUpdate(rutina);
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
		}		
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/editar", method = RequestMethod.GET)
	public String verEditarRutina(Model model, @PathVariable("id") int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			model.addAttribute("rutina", rutina);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "rutina/editar";
	}
	
	@RequestMapping(value ="editarRutina", method = RequestMethod.POST)
	public String editarRutina(Model model, @ModelAttribute("rutina") Rutina rutina)
	{
		try
		{
			rutinaService.saveOrUpdate(rutina);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/detalle", method = RequestMethod.GET)
	public String detalleRutina(Model model, @PathVariable("id") int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			model.addAttribute("rutina", rutina);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "rutina/detalles";
	}
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.GET)
	public String eliminarRutina(Model model,@PathVariable("id") int id)
	{
		Rutina rutina = rutinaService.findById(id);
		rutinaService.delete(rutina);
		return "redirect:/rutina/";
	}
	
}
