package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.EjercicioDAO;
import com.gimnasio.Dao.GrupoMuscularDAO;
import com.gimnasio.Pojo.Ejercicio;

@Service
public class EjercicioService {
	
	@Autowired
	EjercicioDAO ejercicioDAO;
	
	@Autowired
	GrupoMuscularDAO grupoMuscularDAO;
	
	public Ejercicio findById(int id)
	{
		return ejercicioDAO.findById(id);
	}
	
	public List<Ejercicio> findAll()
	{
		return ejercicioDAO.findAll();
	}
	
	public List<Ejercicio> findByGrupoMuscular(int id)
	{
		return ejercicioDAO.findByGrupoMuscular(grupoMuscularDAO.FindById(id));
	}
	
	public void saveOrUpdate(Ejercicio ejercicio)
	{
		if(ejercicio.getId() == 0)
		{
			ejercicioDAO.save(ejercicio);
		}
		else
		{
			ejercicioDAO.update(ejercicio);
		}
	}
	
	public void delete(Ejercicio ejercicio)
	{
		ejercicioDAO.delete(ejercicio);
	}

}
