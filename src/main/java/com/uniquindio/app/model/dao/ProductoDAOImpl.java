package com.uniquindio.app.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uniquindio.app.model.entity.Producto;

@Repository
public class ProductoDAOImpl implements IProductoDAO{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Transactional
	@Override
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		em.persist(producto);
		
	}

	@Override
	public Producto buscarUno(Long id) {
		return em.find(Producto.class, id);
	}

}
