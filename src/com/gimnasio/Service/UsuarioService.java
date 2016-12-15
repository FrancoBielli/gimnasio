package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.UsuarioDAO;
import com.gimnasio.Pojo.Usuario;

@Service
public class UsuarioService {
		
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario findById(int id)
	{
		return usuarioDAO.findById(id);
	}
	
	public List<Usuario> findAll()
	{
		return usuarioDAO.findAll();
	}
	
	public void saveOrUpdate(Usuario usuario)
	{
		if(usuario.getId() == 0)
		{
			usuarioDAO.save(usuario);
		}
		else
		{
			usuarioDAO.update(usuario);
		}
	}
	
	public void delete(Usuario usuario)
	{
		usuarioDAO.delete(usuario);
	}
}
