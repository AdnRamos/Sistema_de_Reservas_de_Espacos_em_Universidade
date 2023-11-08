package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.Usuarios;

public interface UsuariosServiceInterface {
	Usuarios saveUsuarios(Usuarios o);
	Usuarios findUsuariosById(long id);
	Usuarios updateUsuarios(Usuarios u);
	void deleteUsuarios(Usuarios u);
	void deleteUsuarios(long id);
	List<Usuarios> getAllUsuarios();




}