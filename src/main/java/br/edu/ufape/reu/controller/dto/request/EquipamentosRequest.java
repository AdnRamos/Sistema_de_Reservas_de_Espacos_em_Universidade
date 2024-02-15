package br.edu.ufape.reu.controller.dto.request;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.model.Espacos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public  class EquipamentosRequest  {
	private Long id;
	private String nome;
	private String descricao;
	private String status;
	private Espacos espaco;


	public Equipamentos convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Equipamentos obj = modelMapper.map(this, Equipamentos.class);
		return obj;
	}



}
