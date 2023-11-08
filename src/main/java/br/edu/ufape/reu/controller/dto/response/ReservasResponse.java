package br.edu.ufape.reu.controller.dto.response;

import java.util.*;
import java.math.*;
import java.time.LocalDateTime;

import br.edu.ufape.reu.model.*;
import br.edu.ufape.reu.config.SpringApplicationContext;
import org.modelmapper.ModelMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public  class ReservasResponse  {
	private Long id;
	private Long UsuarioID;
	private Long espacoID;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private String finalidade;
	private String status;
	private List<UsuariosResponse> usuarios; 



	public ReservasResponse(Reservas obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);	
	}

}
