package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value ="{id}/asignarDias", method = RequestMethod.GET)
	public String getAsignarDias(Model model, @PathVariable("id") int id)
	{
		int idRutina = id;
		int dias = 0;
		int semanas = 0;
		int ejerciciosPorDia = 0;
		model.addAttribute("dias", dias);
		model.addAttribute("semanas", semanas);
		model.addAttribute("ejerciciosPorDia", ejerciciosPorDia);
		model.addAttribute("idRutina", idRutina);
		return "rutina/asignarDias";
	}
	
	@RequestMapping(value ="/asignarDias", method = RequestMethod.POST)
	public String AsignarDias(Model model, @RequestParam("dias") int dias, 
			@RequestParam("semanas") int semanas, @RequestParam("ejerciciosPorDia") int ejerciciosPorDia,
			@RequestParam("idRutina") int idRutina, RedirectAttributes redirectAttributes)
	{
		int totalDias = dias*semanas;
		System.out.println(dias + " " + semanas + " " + ejerciciosPorDia + " " + idRutina);
		redirectAttributes.addFlashAttribute("totalDias", totalDias);
		redirectAttributes.addFlashAttribute("ejerciciosPorDia", ejerciciosPorDia);
		return "rutina/" + idRutina + "/asignarEjercicios";
	}
	
	@RequestMapping(value="{id}/asignarEjercicios", method = RequestMethod.GET)
	public String getAsignarEjercicios(Model model, @PathVariable("idRutina") int id)
	{
		//model.addAttribute("totalDias", totalDias);
		//model.addAttribute("ejerciciosPorDia", ejerciciosPorDia);
		//model.addAttribute("rutina", rutinaService.findById(id));
		return "rutina/asignarEjercicios";
	}
	
	
	
}
