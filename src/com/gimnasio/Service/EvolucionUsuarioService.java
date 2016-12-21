package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.EvolucionUsuarioDAO;
import com.gimnasio.Dao.UsuarioDAO;
import com.gimnasio.Pojo.EvolucionUsuario;
import com.gimnasio.Pojo.Usuario;

@Service
public class EvolucionUsuarioService {
	
	@Autowired
	EvolucionUsuarioDAO evolucionUsuarioDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	public EvolucionUsuario findById(int id)
	{
		return evolucionUsuarioDAO.findById(id);
	}
	
	public List<EvolucionUsuario> findAll()
	{
		return evolucionUsuarioDAO.listAll();
	}
	
	public List<EvolucionUsuario> listByUsuario(int id)
	{
		return evolucionUsuarioDAO.listEvolucionUsuario(usuarioDAO.findById(id));
	}
	
	public void saveOrUpdate (EvolucionUsuario evolucionUsuario)
	{
		if(evolucionUsuario.getId() == 0)
		{
			evolucionUsuarioDAO.save(evolucionUsuario);
		}
		else
		{
			evolucionUsuarioDAO.update(evolucionUsuario);
		}
	}
	
	public void delete(EvolucionUsuario evolucionUsuario)
	{
		evolucionUsuarioDAO.delete(evolucionUsuario);
	}
	
	public void deleteByUsuario(Usuario usuario)
	{
		evolucionUsuarioDAO.deleteByUsuario(usuario);
	}

}
