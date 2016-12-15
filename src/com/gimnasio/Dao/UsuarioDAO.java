package com.gimnasio.Dao;

import java.util.List;

import com.gimnasio.Pojo.Usuario;

public interface UsuarioDAO {
	
	public void save(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	
	public Usuario findById(int id);
	public Usuario findByEmail(String email);
	public Usuario findByNombre(String nombre);
	public List<Usuario> findAll();

}
