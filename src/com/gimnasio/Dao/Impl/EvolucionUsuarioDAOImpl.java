package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.EvolucionUsuarioDAO;
import com.gimnasio.Pojo.EvolucionUsuario;
import com.gimnasio.Pojo.Usuario;


@Transactional
@Repository
public class EvolucionUsuarioDAOImpl implements EvolucionUsuarioDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(EvolucionUsuario evolucionUsuario) {
		getSession().save(evolucionUsuario);
		
	}

	@Override
	public void update(EvolucionUsuario evolucionUsuario) {
		getSession().update(evolucionUsuario);
		
	}

	@Override
	public void delete(EvolucionUsuario evolucionUsuario) {
		getSession().delete(evolucionUsuario);
		
	}

	@Override
	public EvolucionUsuario findById(int id) {
		Criteria criteria = getSession().createCriteria(EvolucionUsuario.class)
				.add(Restrictions.eq("id", id));
		return (EvolucionUsuario)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EvolucionUsuario> listEvolucionUsuario(Usuario usuario) {
		Criteria criteria = getSession().createCriteria(EvolucionUsuario.class)
				.add(Restrictions.eq("usuario.id", usuario.getId()));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EvolucionUsuario> listAll() {
		Criteria criteria = getSession().createCriteria(EvolucionUsuario.class)
				.setMaxResults(100);
		return criteria.list();
	}

}
