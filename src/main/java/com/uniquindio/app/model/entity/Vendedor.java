package com.uniquindio.app.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombre;
	
	private String direccion;
	
	private String cargo;
	
	private String telefono;
	
	public Vendedor() {
		
	}

	public Vendedor(String nombre, String direccion, String cargo, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.cargo = cargo;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", cargo=" + cargo
				+ ", telefono=" + telefono + "]";
	}
	
	

}
