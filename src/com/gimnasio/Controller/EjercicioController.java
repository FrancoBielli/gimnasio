package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.GrupoMuscular;
import com.gimnasio.Service.EjercicioService;
import com.gimnasio.Service.GrupoMuscularService;

@Controller
@RequestMapping(value="/ejercicio")
public class EjercicioController {

	@Autowired
	private EjercicioService ejercicioService;
	
	@Autowired
	private GrupoMuscularService grupoMuscularService; 
	
	
	@RequestMapping(value ="/")
	public String vacio()
	{
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "index")
	public String ejercicioIndex(Model model)
	{
		List<Ejercicio> ejercicios = ejercicioService.findAll();
		model.addAttribute("ejercicios", ejercicios);
		return "ejercicio/index";
	}
	
	@RequestMapping(value="crear", method = RequestMethod.GET)
	public String verCrearEjercicio(Model model) {
		model.addAttribute("ejercicio", new Ejercicio());
		List<GrupoMuscular> gruposMusculares = grupoMuscularService.findAll();
		model.addAttribute("gruposMusculares", gruposMusculares);
		return "ejercicio/crear";
	}
	
	@RequestMapping(value="crearEjercicio", method = RequestMethod.POST)
	public String crearEjercicio(@ModelAttribute("ejercicio") Ejercicio ejercicio, Model model ){
		System.out.println(ejercicio.toString());
		try
		{
			ejercicioService.saveOrUpdate(ejercicio);
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
		}		
		
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/editar", method = RequestMethod.GET)
	public String verEditarEjercicio(Model model, @PathVariable("id") int id)
	{
		try
		{
			Ejercicio ejercicio = ejercicioService.findById(id);
			List<GrupoMuscular> gruposMusculares = grupoMuscularService.findAll();
			model.addAttribute("ejercicio", ejercicio);
			model.addAttribute("gruposMusculares", gruposMusculares);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "ejercicio/editar";
	}
	
	@RequestMapping(value ="editarEjercicio", method = RequestMethod.POST)
	public String editarEjercicio(Model model, @ModelAttribute("ejercicio") Ejercicio ejercicio)
	{
		try
		{
			ejercicioService.saveOrUpdate(ejercicio);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/detalle", method = RequestMethod.GET)
	public String detalleEjercicio(Model model, @PathVariable("id") int id)
	{
		try
		{
			Ejercicio ejercicio = ejercicioService.findById(id);
			model.addAttribute("ejercicio", ejercicio);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "ejercicio/detalles";
	}
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.GET)
	public String eliminarEjercicio(Model model,@PathVariable("id") int id)
	{
		Ejercicio ejercicio = ejercicioService.findById(id);
		ejercicioService.delete(ejercicio);
		return "redirect:/ejercicio/";
	}
}
