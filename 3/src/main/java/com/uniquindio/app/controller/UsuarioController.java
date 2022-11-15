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

import com.uniquindio.app.model.entity.Producto;
import com.uniquindio.app.model.entity.Usuario;
import com.uniquindio.app.model.service.IUsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping(value = "/listarusuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("titulo", "Lista de Usuarios Registrados");
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
	
	@PostMapping("/formusuario")
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario para crear Usuarios");
			return "formUsuarios";
		}
		
		usuarioService.save(usuario);
		return "redirect:listarusuarios";
	}
	
	@RequestMapping(value = "/formusuario/{id}")
	public String editar(@PathVariable(value="id") Long id,Model model) {
		Usuario usuario = null;
		
		if(id > 0) {
			usuario = usuarioService.buscarUno(id);
		}else {
			return "redirect:/listarusuarios";
		}
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Editar usuario");
		return "formUsuarios";
	}
	
	@RequestMapping(value = "/eliminarusuario/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			usuarioService.delete(id);
		}
		return "redirect:/listarusuarios";
	}

}
