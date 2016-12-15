package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;

public interface RutinaDAO {
	
	public void save(Rutina rutina);
	public void update(Rutina rutina);
	public void delete(Rutina rutina);
	
	public Rutina findById(int id);
	public Rutina findByUsuario(Usuario usuario);
	public List<Rutina> findAll();
}
