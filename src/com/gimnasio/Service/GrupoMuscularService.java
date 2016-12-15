package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.EjercicioDAO;
import com.gimnasio.Dao.GrupoMuscularDAO;
import com.gimnasio.Pojo.GrupoMuscular;

@Service
public class GrupoMuscularService {
	
	@Autowired
	GrupoMuscularDAO grupoMuscularDAO;
	
	@Autowired
	EjercicioDAO ejercicioDAO;
	
	public GrupoMuscular findById(int id)
	{
		return grupoMuscularDAO.FindById(id);
	}
	
	public GrupoMuscular findByEjercicio(int id)
	{
		return grupoMuscularDAO.findByEjercicio(ejercicioDAO.findById(id));
	}
	
	public List<GrupoMuscular> findAll()
	{
		return grupoMuscularDAO.findAll();
	}
	
	public void saveOrUpdate(GrupoMuscular grupoMuscular)
	{
		if(grupoMuscular.getId() == 0)
		{
			grupoMuscularDAO.save(grupoMuscular);
		}
		else
		{
			grupoMuscularDAO.update(grupoMuscular);
		}
	}
	
	public void delete(GrupoMuscular grupoMuscular)
	{
		grupoMuscularDAO.delete(grupoMuscular);
	}
	
}
