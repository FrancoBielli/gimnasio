package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.EjerciciosRutinaDAO;
import com.gimnasio.Pojo.EjerciciosRutina;
import com.gimnasio.Pojo.Rutina;


@Transactional
@Repository
public class EjerciciosRutinaDAOImpl implements EjerciciosRutinaDAO{
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(EjerciciosRutina ejerciciosRutina) {
		getSession().save(ejerciciosRutina);
	}

	@Override
	public void update(EjerciciosRutina ejerciciosRutina) {
		getSession().update(ejerciciosRutina);
	}

	@Override
	public void delete(EjerciciosRutina ejerciciosRutina) {
		getSession().delete(ejerciciosRutina);
	}

	@Override
	public EjerciciosRutina findById(int id) {
		Criteria criteria = getSession().createCriteria(EjerciciosRutina.class)
				.add(Restrictions.eq("id", id));
		return (EjerciciosRutina)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EjerciciosRutina> findByRutina(Rutina rutina) {
		Criteria criteria = getSession().createCriteria(EjerciciosRutina.class)
				.add(Restrictions.eq("rutinas.id", rutina.getId()));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EjerciciosRutina> findAll() {
		Criteria criteria = getSession().createCriteria(EjerciciosRutina.class)
				.setMaxResults(100);
		return criteria.list();
	}

}
