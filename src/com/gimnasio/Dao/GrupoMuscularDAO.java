package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.GrupoMuscular;

public interface GrupoMuscularDAO {
	
	public GrupoMuscular FindById(int id);
	
	public void save(GrupoMuscular grupoMuscular);
	
	public void update(GrupoMuscular grupoMuscular);
	
	public void delete(GrupoMuscular grupoMuscular);
	
	public List<GrupoMuscular> findAll();
	
	public GrupoMuscular findByEjercicio(Ejercicio ejercicio);

}
