package br.edu.ufape.reu.controller.dto.request;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Treinamentos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public  class TreinamentosRequest  {
	private Long id;
	private String descricao;
	private String espacoEquimentosAssociados;


	public Treinamentos convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Treinamentos obj = modelMapper.map(this, Treinamentos.class);
		return obj;
	}



}
