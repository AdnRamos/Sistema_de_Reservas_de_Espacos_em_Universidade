package br.edu.ufape.reu.controller.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.enums.StatusReserva;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Penalidades;
import br.edu.ufape.reu.model.Reservas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class ReservasResponse  {
	private Long id;
	private Long UsuarioID;
	private Long espacoID;
	private String espacoNome;
	private LocalDate data;
	private LocalTime dataHoraInicio;
	private LocalTime dataHoraTermino;
	private String finalidade;
	private StatusReserva status;
	private Penalidades penalidade;

	public ReservasResponse(Reservas obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}

}
