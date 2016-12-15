package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.GrupoMuscular;

public interface EjercicioDAO {
	
	public void save(Ejercicio ejercicio);
	public void update(Ejercicio ejercicio);
	public void delete(Ejercicio ejercicio);
	
	public Ejercicio findById(int id);
	
	public List<Ejercicio> findByGrupoMuscular(GrupoMuscular grupoMuscular);
	
	public List<Ejercicio> findAll();

}
