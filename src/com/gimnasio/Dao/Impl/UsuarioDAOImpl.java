package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.UsuarioDAO;
import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;

@Transactional
@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Usuario usuario) {
		getSession().save(usuario);
		
	}

	@Override
	public void update(Usuario usuario) {
		getSession().update(usuario);
		
	}

	@Override
	public void delete(Usuario usuario) {
		getSession().delete(usuario);
		
	}

	@Override
	public Usuario findById(int id) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id));
		return (Usuario)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add(Restrictions.isNotNull("id"));
		return criteria.list();
	}

	@Override
	public Usuario findByEmail(String email) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email",email));
		return (Usuario)criteria.uniqueResult();
	}

	@Override
	public Usuario findByNombre(String nombre) {
		Criteria criteria = getSession().createCriteria(Usuario.class)
				.add(Restrictions.like("nombre", "%" + nombre + "%"));
		return (Usuario)criteria.uniqueResult();
	}
	@Override
	public void updateRutina(Usuario usuario, Rutina rutina) {
		if(rutina!=null)
		{
			Query query = getSession().createQuery("update Usuario set rutina_id = " + rutina.getId()  +
					" where id = "+ usuario.getId());
			query.executeUpdate();
		}
		else
		{
			Query query = getSession().createQuery("update Usuario set rutina_id = " + null  +
					" where id = "+ usuario.getId());
			query.executeUpdate();
		}
	}

}
