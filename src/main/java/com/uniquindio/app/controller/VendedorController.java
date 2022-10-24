package com.uniquindio.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uniquindio.app.model.service.IVendedorService;

@Controller
public class VendedorController {
	
	@Autowired
	private IVendedorService vendedorService;
	
	@GetMapping(value = "/listarvendedores")
	public String listarVendedores (Model model) {
		
		model.addAttribute("titulo", "Pagina de lista de vendedores registrados");
		model.addAttribute("vendedores", vendedorService.listarVendedores());
		return "listarVendedores";
		
	}

}
