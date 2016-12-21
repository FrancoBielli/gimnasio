package com.gimnasio.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gimnasio.Dao.EjercicioDAO;
import com.gimnasio.Pojo.Ejercicio;
import com.gimnasio.Pojo.GrupoMuscular;


@Transactional
@Repository
public class EjercicioDAOImpl implements EjercicioDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Ejercicio ejercicio) {
		getSession().save(ejercicio);
	}

	@Override
	public void update(Ejercicio ejercicio) {
		getSession().update(ejercicio);
	}

	@Override
	public void delete(Ejercicio ejercicio) {
		getSession().delete(ejercicio);
	}

	@Override
	public Ejercicio findById(int id) {
		Criteria criteria = getSession().createCriteria(Ejercicio.class)
				.add(Restrictions.eq("id", id));
		return (Ejercicio) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ejercicio> findByGrupoMuscular(GrupoMuscular grupoMuscular) {
		try
		{
			Criteria criteria = getSession().createCriteria(Ejercicio.class)
					.add(Restrictions.eq("grupoMuscular.id", grupoMuscular.getId()));
			return criteria.list();
		}
		catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ejercicio> findAll() {
		Criteria criteria = getSession().createCriteria(Ejercicio.class)
				.setMaxResults(100)
				.addOrder(Order.asc("grupoMuscular.id"));
		return criteria.list();
	}

}
