package com.adminUsuarios.apirest.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminUsuarios.model.entity.Usuario;
import com.adminUsuarios.model.entity.dao.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins= {"*"})
public class UsuarioWS {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/")
	public  List<Usuario> prueba() {
		return usuarioService.obtenerListaUsuarios();
	}
	
	
	@GetMapping("/consultarIdentificacion")
	public  List<Usuario> buscarIdentificacion(@RequestParam("identificacion")  String identificacion) {
		return usuarioService.buscarIdentificacion(identificacion);
	}
	
	@GetMapping("/obtenerID")
	public Usuario   obtenerUsuarioId(@RequestParam("id") int id) {
		Usuario usuario = usuarioService.obtenerID(id);
		if (usuario ==null) {
			usuario = new Usuario();
		}
		return usuario;
	}
	
	@PostMapping("/")
	public  Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.agregarUsuario(usuario);
	}
	
	@DeleteMapping("/")
	public String eliminarUsuario (@RequestParam("id") int id){
		
		usuarioService.eliminar(id);
		return "Eliminado";
	}
	
	@PutMapping("/")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		
		return usuarioService.actualizar(usuario);
	}
	
	@GetMapping("/prueba")
	public String pruebaWS() {
		return "ok";
	}
}