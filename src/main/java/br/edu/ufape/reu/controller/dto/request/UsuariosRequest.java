package br.edu.ufape.reu.controller.dto.request;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Usuarios;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public  class UsuariosRequest  {
	private Long id;
	private String nome;
	private String email;
	private String tipo;
	private List<CertificacoesTreinamentoRequest> certificacoesTreinamento;


	public Usuarios convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Usuarios obj = modelMapper.map(this, Usuarios.class);
		return obj;
	}



}
