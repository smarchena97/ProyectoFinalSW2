package com.uniquindio.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniquindio.app.model.dao.IProductoDAO;
import com.uniquindio.app.model.entity.Producto;

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoDAO productoDAO;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de productos");
		model.addAttribute("productos", productoDAO.listarProductos());
		return "listar";
		
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		model.addAttribute("titulo", "Formulario para crear productos");
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Producto producto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario para crear productos");
			return "form";
		}
		
		productoDAO.save(producto);
		return "redirect:listar";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value="id") Long id,Model model) {
		Producto producto = null;
		
		if(id > 0) {
			producto = productoDAO.buscarUno(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("producto", producto);
		model.addAttribute("titulo", "Editar producto");
		return "form";
	}

}
