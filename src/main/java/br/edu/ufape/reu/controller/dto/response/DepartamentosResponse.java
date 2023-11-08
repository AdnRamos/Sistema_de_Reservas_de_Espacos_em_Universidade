package br.edu.ufape.reu.controller.dto.response;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Departamentos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class DepartamentosResponse  {
	private Long id;
	private String nome;
	private String responsavel;
	private String contato;
	private List<EspacosResponse> espacos;



	public DepartamentosResponse(Departamentos obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}

}
