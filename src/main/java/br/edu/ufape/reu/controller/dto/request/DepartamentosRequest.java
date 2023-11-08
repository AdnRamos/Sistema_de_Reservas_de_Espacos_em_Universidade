package br.edu.ufape.reu.controller.dto.request;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.*;

import java.util.*;
import java.math.*;

import org.modelmapper.ModelMapper;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor 
public  class DepartamentosRequest  {
	private Long id;
	private String nome;
	private String responsavel;
	private String contato;
	private List<EspacosRequest> espacos; 


	public Departamentos convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Departamentos obj = modelMapper.map(this, Departamentos.class);
		return obj;
	}



}
