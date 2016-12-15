package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.EjerciciosRutina;
import com.gimnasio.Pojo.Rutina;

public interface EjerciciosRutinaDAO {
	
	public void save(EjerciciosRutina ejerciciosRutina);
	public void update(EjerciciosRutina ejerciciosRutina);
	public void delete(EjerciciosRutina ejerciciosRutina);
	
	public EjerciciosRutina findById(int id);
	public List<EjerciciosRutina> findByRutina(Rutina rutina);
	public List<EjerciciosRutina> findAll();

}
