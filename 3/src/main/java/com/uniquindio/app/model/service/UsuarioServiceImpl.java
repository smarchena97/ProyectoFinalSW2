package com.uniquindio.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniquindio.app.model.dao.IUsuarioDAO;
import com.uniquindio.app.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO usuarioDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Transactional
	@Override
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
		
	}

	@Transactional
	@Override
	public Usuario buscarUno(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		
		usuarioDAO.deleteById(id);
		
	}

}
