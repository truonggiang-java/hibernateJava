package com.example.hibernate.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.websocket.ClientEndpointConfig.Builder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernate.entity.Product;
import com.example.hibernate.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public ProductRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void insert(Product p) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public List<Product> findAllProduct() {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root);
		Query<Product> query=session.createQuery(criteriaQuery);
		List<Product> results=query.getResultList();
		return results;
	}

	@Override
	public Product findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(Product.class, id);
	}

	@Override
	public void update(Product p) {
		Session session=sessionFactory.getCurrentSession();
		session.update(p);
		
	}

}
