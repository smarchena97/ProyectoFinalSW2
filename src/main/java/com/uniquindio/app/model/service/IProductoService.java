package com.uniquindio.app.model.service;

import java.util.List;

import com.uniquindio.app.model.entity.Producto;

public interface IProductoService {

	public List<Producto> listarProductos();

	public void save(Producto producto);

	public Producto buscarUno(Long id);

	public void delete(Long id);

}
