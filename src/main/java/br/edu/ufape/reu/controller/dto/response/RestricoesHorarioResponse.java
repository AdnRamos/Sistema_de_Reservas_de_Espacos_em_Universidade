package br.edu.ufape.reu.controller.dto.response;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.RestricoesHorario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class RestricoesHorarioResponse  {
	private Long id;
	private Long espacoID;
	private String diaSemana;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioTermino;
	private String mobile;



	public RestricoesHorarioResponse(RestricoesHorario obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}

}
