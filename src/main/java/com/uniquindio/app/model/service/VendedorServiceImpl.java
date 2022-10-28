package com.uniquindio.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniquindio.app.model.dao.IVendedorDAO;
import com.uniquindio.app.model.entity.Vendedor;

@Service
public class VendedorServiceImpl implements IVendedorService{
	
	@Autowired
	IVendedorDAO vendedorDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> listarVendedores() {
		return (List<Vendedor>) vendedorDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Vendedor vendedor) {
		vendedorDAO.save(vendedor);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Vendedor buscarUno(Long id) {
		return vendedorDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		vendedorDAO.deleteById(id);
	}

}
