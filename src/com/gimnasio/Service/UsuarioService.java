package com.gimnasio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gimnasio.Dao.UsuarioDAO;
import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;

@Service
public class UsuarioService {
		
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario findById(int id)
	{
		return usuarioDAO.findById(id);
	}
	
	public List<Usuario> findAll()
	{
		return usuarioDAO.findAll();
	}
	
	public Usuario findByEmail(String email)
	{
		return usuarioDAO.findByEmail(email);
	}
	
	public void saveOrUpdate(Usuario usuario)
	{
		String passwordUsuario = usuario.getPassword();
		usuario.setPassword(passwordEncoder.encode(passwordUsuario));
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
	
	public void updateRutina(Usuario usuario, Rutina rutina)
	{
		usuarioDAO.updateRutina(usuario, rutina);
	}
}
