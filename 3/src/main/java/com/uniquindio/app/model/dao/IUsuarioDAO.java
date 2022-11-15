package com.uniquindio.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.uniquindio.app.model.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

}
