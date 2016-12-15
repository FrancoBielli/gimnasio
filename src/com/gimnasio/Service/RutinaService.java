package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.RutinaDAO;
import com.gimnasio.Dao.UsuarioDAO;
import com.gimnasio.Pojo.Rutina;

@Service
public class RutinaService {
	
	@Autowired
	private RutinaDAO rutinaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Rutina findById(int id)
	{
		return rutinaDAO.findById(id);
	}
	
	public List<Rutina> findAll()
	{
		return rutinaDAO.findAll();
	}
	
	public Rutina findByUsuario(int id)
	{
		return rutinaDAO.findByUsuario(usuarioDAO.findById(id));
	}
	
	public void saveOrUpdate(Rutina rutina)
	{
		if(rutina.getId() == 0 )
		{
			rutinaDAO.save(rutina);
		}
		else
		{
			rutinaDAO.update(rutina);
		}
	}
	
	public void delete(Rutina rutina)
	{
		rutinaDAO.delete(rutina);
	}
}
