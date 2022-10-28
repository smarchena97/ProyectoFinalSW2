package com.uniquindio.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniquindio.app.model.entity.Usuario;
import com.uniquindio.app.model.entity.Vendedor;
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
	
	@RequestMapping(value = "/formvendedor")
	public String crearVendedor(Model model) {
		Vendedor vendedor = new Vendedor();
		model.addAttribute("titulo", "Formulario para crear un Vendedor");
		model.addAttribute("vendedor", vendedor);
		return "formVendedor";
		
	}
	
	@PostMapping("/formvendedor")
	public String guardar(@Valid Vendedor vendedor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario para crear un Vendedor");
			return "formVendedor";
		}
		
		vendedorService.save(vendedor);
		return "redirect:listarvendedores";
	}
	
	@RequestMapping(value = "/formvendedor/{id}")
	public String editar(@PathVariable(value="id") Long id,Model model) {
		Vendedor vendedor = null;
		
		if(id > 0) {
			vendedor = vendedorService.buscarUno(id);
		}else {
			return "redirect:/listarvendedores";
		}
		model.addAttribute("vendedor", vendedor);
		model.addAttribute("titulo", "Editar Vendedor");
		return "formVendedor";
	}
	
	@RequestMapping(value = "/eliminarvendedor/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			vendedorService.delete(id);
		}
		return "redirect:/listarvendedores";
	}

}
