package br.edu.ufape.reu.controller.dto.response;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Equipamentos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class EquipamentosResponse  {
	private Long id;
	private String nome;
	private String descricao;
	private int quantidadeDisponivel;
	private String status;



	public EquipamentosResponse(Equipamentos obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}

}
