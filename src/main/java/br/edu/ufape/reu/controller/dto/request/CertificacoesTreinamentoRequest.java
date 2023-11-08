package br.edu.ufape.reu.controller.dto.request;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.*;

import java.util.*;
import java.math.*;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor 
public  class CertificacoesTreinamentoRequest  {
	private Long usuarioID;
	private String treinamentoID;
	private LocalDate dataObtencao;
	private LocalDate dataValidade;
	private List<TreinamentosRequest> treinamentos; 


	public CertificacoesTreinamento convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		CertificacoesTreinamento obj = modelMapper.map(this, CertificacoesTreinamento.class);
		return obj;
	}



}
