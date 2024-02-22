package br.edu.ufape.reu.controller.dto.request;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.enums.TipoEspaco;
import br.edu.ufape.reu.model.Departamentos;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Fotos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public  class EspacosRequest  {
	private Long id;
	private String nome;
	private String regrasEspecificas;
	private TipoEspaco tipo;
	private int capacidade;
	private List<Fotos> fotos;
	private Departamentos departamento;
	private List<EquipamentosRequest> equipamentos;
	private List<ReservasRequest> reservas;

	public Espacos convertToEntity() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Espacos obj = modelMapper.map(this, Espacos.class);
		return obj;
	}



}
