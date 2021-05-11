package com.example.hibernate.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entity.Brand;
import com.example.hibernate.repository.BrandRepository;

@Repository
public class BrandRepositoryImpl implements BrandRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public BrandRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void insert(Brand b) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(b);	
	}

	@Override
	public void update(Brand b) {
		Session session =sessionFactory.getCurrentSession();
		session.update(b);;
	}

	@Override
	public void delete(Brand b) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(b);
		
	}

	@Override
	public Brand findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(Brand.class, id);
	}

	@Override
	public List<Brand> findAllBrand() {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Brand> criteriaQuery=criteriaBuilder.createQuery(Brand.class);
		Root<Brand> root=criteriaQuery.from(Brand.class);
		criteriaQuery.select(root);
		Query<Brand> query=session.createQuery(criteriaQuery);
		List<Brand> results=query.getResultList();
		return results;
	}

}
