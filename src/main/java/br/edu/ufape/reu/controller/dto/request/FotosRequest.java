package br.edu.ufape.reu.controller.dto.request;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Fotos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FotosRequest {
  private Long id;
  private Long espacoID;
  private Long equipamentoID;
  private String urlImage;

  public Fotos convertToEntity(){
    ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
    Fotos obj = modelMapper.map(this, Fotos.class);
    return obj;
  }

}
