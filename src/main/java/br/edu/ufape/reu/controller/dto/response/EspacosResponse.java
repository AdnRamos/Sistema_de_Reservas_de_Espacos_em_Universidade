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
public  class EspacosResponse  {
	private Long id;
	private String nome;
	private String tipo;
	private int capacidade;
	private String equipamentosDisponiveis;
	private String fotos;
	private String horarioDisponivel;
	private Long departamentoID;
	private List<EquipamentosResponse> equipamentos; 
	private List<ReservasResponse> reservas; 
	private List<RestricoesHorarioResponse> restricoesHorario; 



	public EspacosResponse(Espacos obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);	
	}

}
