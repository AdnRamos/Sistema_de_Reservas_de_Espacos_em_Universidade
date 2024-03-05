package br.edu.ufape.reu.controller.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.enums.StatusReserva;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.model.Usuarios;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
public  class ReservasRequest  {
	private LocalDate data;
	private LocalTime dataHoraInicio;
	private LocalTime dataHoraTermino;
	private String finalidade;
	private StatusReserva status;
	private Usuarios usuario;
	private Espacos espaco;

	public Reservas convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Reservas obj = modelMapper.map(this, Reservas.class);
		return obj;
	}



}
