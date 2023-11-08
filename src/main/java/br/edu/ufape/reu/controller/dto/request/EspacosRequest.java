package br.edu.ufape.reu.controller.dto.request;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Espacos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public  class EspacosRequest  {
	private Long id;
	private String nome;
	private String tipo;
	private int capacidade;
	private String equipamentosDisponiveis;
	private String fotos;
	private String horarioDisponivel;
	private Long departamentoID;
	private List<EquipamentosRequest> equipamentos;
	private List<ReservasRequest> reservas;
	private List<RestricoesHorarioRequest> restricoesHorario;


	public Espacos convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Espacos obj = modelMapper.map(this, Espacos.class);
		return obj;
	}



}
