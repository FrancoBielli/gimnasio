package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.GrupoMuscularDAO;
import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.GrupoMuscular;


@Transactional
@Repository
public class GrupoMuscularDAOImpl implements GrupoMuscularDAO{

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(GrupoMuscular grupoMuscular) {
		getSession().save(grupoMuscular);
		
	}

	@Override
	public void update(GrupoMuscular grupoMuscular) {
		getSession().update(grupoMuscular);
		
	}

	@Override
	public void delete(GrupoMuscular grupoMuscular) {
		getSession().delete(grupoMuscular);
		
	}
	
	@Override
	public GrupoMuscular FindById(int id) {
		Criteria criteria = getSession().createCriteria(GrupoMuscular.class)
				.add(Restrictions.eq("id", id));
		return (GrupoMuscular)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GrupoMuscular> findAll() {
		Criteria criteria = getSession().createCriteria(GrupoMuscular.class)
				.setMaxResults(100);
		return criteria.list();
	}

	@Override
	public GrupoMuscular findByEjercicio(Ejercicio ejercicio) {
		Criteria criteria = getSession().createCriteria(GrupoMuscular.class)
				.add(Restrictions.eq("id", ejercicio.getGrupoMuscular().getId()));
		return (GrupoMuscular)criteria.uniqueResult();
	}

}
