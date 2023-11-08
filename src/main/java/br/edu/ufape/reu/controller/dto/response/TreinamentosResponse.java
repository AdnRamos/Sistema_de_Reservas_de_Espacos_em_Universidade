package br.edu.ufape.reu.controller.dto.response;

import java.util.*;
import java.math.*;
import br.edu.ufape.reu.model.*;
import br.edu.ufape.reu.config.SpringApplicationContext;
import org.modelmapper.ModelMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class TreinamentosResponse  {
	private Long id;
	private String descricao;
	private String espacoEquimentosAssociados;



	public TreinamentosResponse(Treinamentos obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);	
	}

}
