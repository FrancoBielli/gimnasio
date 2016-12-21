package com.gimnasio.Controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.EjerciciosRutina;
import com.gimnasio.Pojo.EjerciciosRutinaForm;
import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Service.EjercicioService;
import com.gimnasio.Service.EjerciciosRutinaService;
import com.gimnasio.Service.RutinaService;

@Controller
@SessionAttributes({"ejerciciosPorDia", "idRutina", "dias", "semanas"})
@RequestMapping(value="/rutina")
public class RutinaController {
	
	@Autowired
	private RutinaService rutinaService;
	
	@Autowired
	private EjercicioService ejercicioService;
	
	@Autowired
	private EjerciciosRutinaService ejerciciosRutinaService;
	
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
	public String crearRutina(@ModelAttribute("rutina") @Valid Rutina rutina, BindingResult result,
			Model model ){
		if(!result.hasErrors())
		{
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
		return "rutina/crear";
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
	public String editarRutina(Model model, @ModelAttribute("rutina") @Valid Rutina rutina, 
			BindingResult result)
	{
		if(!result.hasErrors())
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
		return "rutina/editar";
	}
	
	@RequestMapping(value = "{id}/detalle", method = RequestMethod.GET)
	public String detalleRutina(Model model, @PathVariable("id") int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaService.findByRutina(rutina.getId());;
			model.addAttribute("rutina", rutina);
			model.addAttribute("ejerciciosRutina", ejerciciosRutina);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "rutina/detalles";
	}
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.GET)
	public String eliminarRutina(Model model,@PathVariable("id") int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaService.findByRutina(rutina.getId());
			for(EjerciciosRutina ejerut : ejerciciosRutina)
			{
				ejerciciosRutinaService.delete(ejerut);
			}
			rutinaService.delete(rutina);
			return "redirect:/rutina/";
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return "redirect:/rutina/";
	}
	
	@RequestMapping(value="/{id}/asignarEjercicios", method = RequestMethod.GET)
	public String getAsignarEjercicios(Model model, @PathVariable("id")int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			EjerciciosRutinaForm ejerciciosRutinaForm = new EjerciciosRutinaForm();
			List<EjerciciosRutina> ejerciciosRutina = new ArrayList<EjerciciosRutina>();
			for(int i=0; i<rutina.getSemanas(); i++)
			{
				for(int k = 0; k<rutina.getDias(); k++)
				{
					for(int j = 0; j<rutina.getEjerciciosPorDia(); j++)
					{
						EjerciciosRutina ejercicioRutina = new EjerciciosRutina();
						ejercicioRutina.setDia(k);
						ejercicioRutina.setDescanso(0);
						ejercicioRutina.setPeso(0);
						ejercicioRutina.setRepeticiones(0);
						ejercicioRutina.setRutina(rutina);
						ejerciciosRutina.add(ejercicioRutina);
					}
				}
			}
			ejerciciosRutinaForm.setEjerciciosRutina(ejerciciosRutina);
			model.addAttribute("rutina", rutina);
			model.addAttribute("rutinaId", rutina.getId());
			model.addAttribute("ejerciciosRutinaForm", ejerciciosRutinaForm);
			List<Ejercicio> ejercicios = ejercicioService.findAll();
			model.addAttribute("ejercicios", ejercicios);
			return "rutina/asignarEjercicios"; 
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return "redirect:/rutina/index";
	}

	@RequestMapping(value="asignarEjercicios", method = RequestMethod.POST)
	public String AsignarEjercicios(
			@ModelAttribute("ejerciciosRutinaForm") @Valid EjerciciosRutinaForm ejerciciosRutinaForm,
			BindingResult result, Model model, @RequestParam("rutinaId")int rutinaId)
	{
		if(!result.hasErrors())
		{
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaForm.getEjerciciosRutina();
			try
			{
				ejerciciosRutinaService.guardarLote(ejerciciosRutina);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			return "redirect:index";
		}
		Rutina rutina = rutinaService.findById(rutinaId);
		model.addAttribute("rutina", rutina);
		return "rutina/asignarEjercicios"; 
	}
	
	@RequestMapping(value="/{id}/editarEjercicios", method = RequestMethod.GET)
	public String getEditarEjercicios(Model model, @PathVariable("id")int id)
	{
		model.addAttribute("rutinaId", id);
		List<Ejercicio> ejercicios = ejercicioService.findAll();
		model.addAttribute("ejercicios", ejercicios);
		Rutina rutina = rutinaService.findById(id);
		EjerciciosRutinaForm ejerciciosRutinaForm = new EjerciciosRutinaForm();
		List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaService.findByRutina(id);
		ejerciciosRutinaForm.setEjerciciosRutina(ejerciciosRutina);
		model.addAttribute("ejerciciosRutinaForm", ejerciciosRutinaForm);
		model.addAttribute("rutina", rutina);
		return "rutina/editarEjercicios";
	}
	
	@RequestMapping(value="editarEjercicios", method = RequestMethod.POST)
	public String editarEjercicios(
			@ModelAttribute("ejerciciosRutinaForm") @Valid EjerciciosRutinaForm ejerciciosRutinaForm,
			BindingResult result, Model model, @RequestParam("rutinaId")int rutinaId)
	{
		if(!result.hasErrors())
		{
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaForm.getEjerciciosRutina();
			try
			{
				for(EjerciciosRutina ejerut: ejerciciosRutina)
				{
					ejerciciosRutinaService.saveOrUpdate(ejerut);
				}
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			return "redirect:index";
		}
		Rutina rutina = rutinaService.findById(rutinaId);
		model.addAttribute("rutina", rutina);
		return "rutina/editarEjercicios"; 
	}
	
	@RequestMapping(value = "{id}/eliminarEjercicios", method = RequestMethod.GET)
	public String eliminarEjerciciosRutina(Model model,@PathVariable("id") int id)
	{
		try
		{
			Rutina rutina = rutinaService.findById(id);
			List<EjerciciosRutina> ejerciciosRutina = ejerciciosRutinaService.findByRutina(rutina.getId());
			for(EjerciciosRutina ejerut : ejerciciosRutina)
			{
				ejerciciosRutinaService.delete(ejerut);
			}
			return "redirect:/rutina/";
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return "redirect:/rutina/";
	}
}
