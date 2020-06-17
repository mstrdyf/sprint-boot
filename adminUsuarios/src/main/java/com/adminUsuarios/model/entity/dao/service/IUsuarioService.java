package com.adminUsuarios.model.entity.dao.service;

import java.util.List;
import com.adminUsuarios.model.entity.Usuario;

public interface IUsuarioService {

	public List< Usuario > obtenerListaUsuarios();
	
	public Usuario obtenerID(int id);
	
	public Usuario agregarUsuario(Usuario usuario);
	
	public void eliminar(int id);
	
	public Usuario actualizar(Usuario usuario);
	
	public List< Usuario >  buscarIdentificacion(String identificacion);
}
