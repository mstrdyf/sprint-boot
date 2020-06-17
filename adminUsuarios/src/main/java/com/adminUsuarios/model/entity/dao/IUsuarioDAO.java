package com.adminUsuarios.model.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminUsuarios.model.entity.Usuario;

@Repository
public interface IUsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	@Query("SELECT  U FROM Usuario U WHERE  U.identificacion = :identificacion")
	public List<Usuario> buscarIdentificacion (@Param("identificacion") String identificacion);

}
