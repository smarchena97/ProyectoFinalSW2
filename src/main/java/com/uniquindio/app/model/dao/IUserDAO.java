package com.uniquindio.app.model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniquindio.app.model.entity.User;

@Repository
public interface IUserDAO extends CrudRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);

}
