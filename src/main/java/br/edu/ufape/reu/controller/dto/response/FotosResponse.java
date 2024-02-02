package br.edu.ufape.reu.controller.dto.response;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Fotos;
import ch.qos.logback.core.model.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FotosResponse {

  private Long id;
  private Long espacoID;
  private Long equipamentoID;
  private String urlImage;

public FotosResponse(Fotos obj){
  ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
  modelMapper.map(obj, this);
}
  
}
