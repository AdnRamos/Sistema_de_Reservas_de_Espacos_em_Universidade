package br.edu.ufape.reu.controller.dto.response;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.CertificacoesTreinamento;
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
