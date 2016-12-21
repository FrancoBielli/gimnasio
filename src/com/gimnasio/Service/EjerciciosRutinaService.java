package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.EjerciciosRutinaDAO;
import com.gimnasio.Dao.RutinaDAO;
import com.gimnasio.Pojo.EjerciciosRutina;

@Service
public class EjerciciosRutinaService {
	
	@Autowired
	EjerciciosRutinaDAO ejerciciosRutinaDAO;
	
	@Autowired
	RutinaDAO rutinaDAO;
	
	public EjerciciosRutina findById(int id)
	{
		return ejerciciosRutinaDAO.findById(id);
	}
	
	public List<EjerciciosRutina> findByRutina(int id)
	{
		return ejerciciosRutinaDAO.findByRutina(rutinaDAO.findById(id));
	}
	
	public List<EjerciciosRutina> findAll()
	{
		return ejerciciosRutinaDAO.findAll();
	}
	
	public void saveOrUpdate(EjerciciosRutina ejerciciosRutina)
	{
		if(ejerciciosRutina.getId() == 0)
		{
			ejerciciosRutinaDAO.save(ejerciciosRutina);
		}
		else
		{
			ejerciciosRutinaDAO.update(ejerciciosRutina);
		}
	}
	
	public void delete (EjerciciosRutina ejerciciosRutina)
	{
		ejerciciosRutinaDAO.delete(ejerciciosRutina);
	}
	
	public void guardarLote(List<EjerciciosRutina> listaEjerciciosRutina)
	{
		for(EjerciciosRutina ejercicio : listaEjerciciosRutina)
		{
			ejerciciosRutinaDAO.save(ejercicio);
		}
	}
}
