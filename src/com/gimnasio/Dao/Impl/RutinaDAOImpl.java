package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.RutinaDAO;
import com.gimnasio.Pojo.Rutina;
import com.gimnasio.Pojo.Usuario;

@Transactional
@Repository
public class RutinaDAOImpl implements RutinaDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{	
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Rutina rutina) {
		getSession().save(rutina);		
	}

	@Override
	public void update(Rutina rutina) {
		getSession().update(rutina);
		
	}

	@Override
	public void delete(Rutina rutina) {
		getSession().delete(rutina);
		
	}

	@Override
	public Rutina findById(int id) {
		Criteria criteria = getSession().createCriteria(Rutina.class)
				.add(Restrictions.eq("id", id));
		return (Rutina) criteria.uniqueResult();
	}

	@Override
	public Rutina findByUsuario(Usuario usuario) {
		try
		{
			Criteria criteria = getSession().createCriteria(Rutina.class)
					.add(Restrictions.eq("id", usuario.getRutina().getId()));
			return (Rutina) criteria.uniqueResult();
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rutina> findAll() {
		Criteria criteria = getSession().createCriteria(Rutina.class)
				.setMaxResults(100);
			return criteria.list();
	}
}
