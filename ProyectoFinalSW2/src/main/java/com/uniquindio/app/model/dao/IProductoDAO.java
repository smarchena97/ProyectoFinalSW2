package com.uniquindio.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniquindio.app.model.entity.Producto;


public interface IProductoDAO extends CrudRepository<Producto, Long>{
	
	
}
