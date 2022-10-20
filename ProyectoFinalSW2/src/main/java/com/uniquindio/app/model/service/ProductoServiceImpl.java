package com.uniquindio.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniquindio.app.model.dao.IProductoDAO;
import com.uniquindio.app.model.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDAO productoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Producto producto) {
		productoDAO.save(producto);

	}

	@Transactional(readOnly = true)
	@Override
	public Producto buscarUno(Long id) {
		return productoDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		productoDAO.deleteById(id);

	}

}
