package com.gimnasio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gimnasio.Pojo.GrupoMuscular;
import com.gimnasio.Service.GrupoMuscularService;

@Controller
@RequestMapping(value = "/grupoMuscular")
public class GrupoMuscularController {
	
	@Autowired
	private GrupoMuscularService grupoMuscularService;
	
	@RequestMapping(value ="/")
	public String vacio()
	{
		return "redirect:index";
	}
	
	@RequestMapping(value ="/index", method = RequestMethod.GET)
	public String index(Model model)
	{
		List<GrupoMuscular> GruposMusculares = grupoMuscularService.findAll();
		model.addAttribute("gruposMusculares", GruposMusculares);
		return "grupoMuscular/index";
	}
	
	@RequestMapping(value="crear", method = RequestMethod.GET)
	public String verCrearGrupoMuscular(Model model) {
		model.addAttribute("grupoMuscular", new GrupoMuscular());
		return "grupoMuscular/crear";
	}
	
	@RequestMapping(value="crearGrupoMuscular", method = RequestMethod.POST)
	public String crearGrupoMuscular(@ModelAttribute("grupoMuscular") GrupoMuscular grupoMuscular, Model model ){
		try
		{
			grupoMuscularService.saveOrUpdate(grupoMuscular);
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
		}
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/editar", method = RequestMethod.GET)
	public String verEditarGrupoMuscular(Model model, @PathVariable("id") int id)
	{
		try
		{
			GrupoMuscular grupoMuscular = grupoMuscularService.findById(id);
			model.addAttribute("grupoMuscular", grupoMuscular);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "grupoMuscular/editar";
	}
	
	@RequestMapping(value = "{id}/detalle", method = RequestMethod.GET)
	public String detalleGrupoMuscular(Model model, @PathVariable("id") int id)
	{
		try
		{
			GrupoMuscular grupoMuscular = grupoMuscularService.findById(id);
			model.addAttribute("grupoMuscular", grupoMuscular);
		}
		catch (Exception e) {
			System.out.print(e.toString());
		}
		return "grupoMuscular/detalles";
	}
	@RequestMapping(value ="editarGrupoMuscular", method = RequestMethod.POST)
	public String editarGrupoMuscular(Model model, @ModelAttribute("grupoMuscular") GrupoMuscular grupoMuscular)
	{
		try
		{
			grupoMuscularService.saveOrUpdate(grupoMuscular);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return "redirect:index";
	}
	
	@RequestMapping(value = "{id}/eliminar", method = RequestMethod.POST)
	public String eliminarGrupoMuscular(Model model,@PathVariable("id") int id)
	{
		GrupoMuscular grupoMuscular = grupoMuscularService.findById(id);
		grupoMuscularService.delete(grupoMuscular);
		return "redirect:index";
	}
	
}
