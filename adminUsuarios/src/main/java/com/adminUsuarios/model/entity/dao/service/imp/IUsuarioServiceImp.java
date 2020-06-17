package com.adminUsuarios.model.entity.dao.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminUsuarios.model.entity.Usuario;
import com.adminUsuarios.model.entity.dao.IUsuarioDAO;
import com.adminUsuarios.model.entity.dao.service.IUsuarioService;

@Service
public class IUsuarioServiceImp  implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usarioDAO;

	@Override
	public List<Usuario> obtenerListaUsuarios() {
		return (List<Usuario>) usarioDAO.findAll();
	}

	@Override
	public Usuario obtenerID(int id) {
		
		return usarioDAO.findById(id).orElse(null);
	}

	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		return  usarioDAO.save(usuario) ;
	}

	@Override
	public void eliminar(int id) {
		 usarioDAO.deleteById(id);
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		return usarioDAO.save(usuario);
	}

	@Override
	public List<Usuario> buscarIdentificacion(String identificacion) {
		return usarioDAO.buscarIdentificacion(identificacion);
	}
}