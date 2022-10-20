package com.uniquindio.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquindio.app.model.dao.IUsuarioDAO;
import com.uniquindio.app.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
		
	}

	@Override
	public Usuario buscarUno(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		
		usuarioDAO.deleteById(id);
		
	}

}
