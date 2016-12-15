package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.EvolucionUsuario;
import com.gimnasio.Pojo.Usuario;

public interface EvolucionUsuarioDAO {
	
	public void save(EvolucionUsuario evolucionUsuario);
	public void update(EvolucionUsuario evolucionUsuario);
	public void delete(EvolucionUsuario evolucionUsuario);
	
	public EvolucionUsuario findById(int id);
	public List<EvolucionUsuario> listEvolucionUsuario(Usuario usuario);
	public List<EvolucionUsuario> listAll();
}
