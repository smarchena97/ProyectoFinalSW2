package com.uniquindio.app.model.dao;

import java.util.List;

import com.uniquindio.app.model.entity.Producto;

public interface IProductoDAO {
	
	public List<Producto> listarProductos();
	
	public void save(Producto producto);
	
	public Producto buscarUno(Long id);

}
