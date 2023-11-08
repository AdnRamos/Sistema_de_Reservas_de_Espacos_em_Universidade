package br.edu.ufape.reu.controller.dto.response;

import java.util.*;
import java.math.*;
import java.time.LocalDate;

import br.edu.ufape.reu.model.*;
import br.edu.ufape.reu.config.SpringApplicationContext;
import org.modelmapper.ModelMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class CertificacoesTreinamentoResponse  {
	private Long id;
	private Long usuarioID;
	private String treinamentoID;
	private LocalDate dataObtencao;
	private LocalDate dataValidade;
	private List<TreinamentosResponse> treinamentos; 



	public CertificacoesTreinamentoResponse(CertificacoesTreinamento obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);	
	}

}
