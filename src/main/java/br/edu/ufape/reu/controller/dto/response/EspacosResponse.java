package br.edu.ufape.reu.controller.dto.response;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Espacos;
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
