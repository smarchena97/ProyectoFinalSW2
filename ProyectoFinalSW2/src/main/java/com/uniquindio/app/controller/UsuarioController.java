package com.uniquindio.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniquindio.app.model.entity.Usuario;
import com.uniquindio.app.model.service.IUsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping(value = "/listarusuarios")
	public String listarUsuarios(Model model) {
		
		model.addAttribute("Titulo", "Lista de Usuarios Registrados");
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "listarUsuarios";
	}
	
	@RequestMapping(value = "/formusuario")
	public String crearUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario para crear Usuario");
		model.addAttribute("usuario", usuario);
		return "formUsuarios";
	}

}
