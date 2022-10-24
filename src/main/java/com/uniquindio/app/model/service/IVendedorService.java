package com.uniquindio.app.model.service;

import java.util.List;

import com.uniquindio.app.model.entity.Vendedor;

public interface IVendedorService {
	
	public List<Vendedor> listarVendedores();
	
	public void save(Vendedor vendedor);
	
	public Vendedor buscarUno(Long id);
	
	public void delete(Long id);

}
