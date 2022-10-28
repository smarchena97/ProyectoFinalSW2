package com.uniquindio.app.model.service;

import java.util.List;

import com.uniquindio.app.model.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listarUsuarios();

	public void save(Usuario usuario);

	public Usuario buscarUno(Long id);

	public void delete(Long id);

}
