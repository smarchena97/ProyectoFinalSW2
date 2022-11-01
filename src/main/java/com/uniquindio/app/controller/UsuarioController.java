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
		
<<<<<<< HEAD
		model.addAttribute("titulo", "Lista de Usuarios Registrados");
=======
		model.addAttribute("Titulo", "Lista de Usuarios Registrados");
>>>>>>> 2e0862f286c6764dbd6165b4c7a5a2ef2b651dc9
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
<<<<<<< HEAD
		return "redirect:listarusuarios";
=======
		return "redirect:listarUsuarios";
>>>>>>> 2e0862f286c6764dbd6165b4c7a5a2ef2b651dc9
	}
	
	@RequestMapping(value = "/formusuario/{id}")
	public String editar(@PathVariable(value="id") Long id,Model model) {
		Usuario usuario = null;
		
		if(id > 0) {
			usuario = usuarioService.buscarUno(id);
		}else {
<<<<<<< HEAD
			return "redirect:/listarusuarios";
=======
			return "redirect:/listarUsuarios";
>>>>>>> 2e0862f286c6764dbd6165b4c7a5a2ef2b651dc9
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
<<<<<<< HEAD
		return "redirect:/listarusuarios";
=======
		return "redirect:/listarUsuarios";
>>>>>>> 2e0862f286c6764dbd6165b4c7a5a2ef2b651dc9
	}

}
