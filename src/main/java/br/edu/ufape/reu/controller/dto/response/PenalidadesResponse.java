package br.edu.ufape.reu.controller.dto.response;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Penalidades;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PenalidadesResponse {
  private Long id;
  private Long idReserva;
  private String justificativa;

  public PenalidadesResponse(Penalidades obj) {
    ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");  
    modelMapper.map(obj, this);
  }
  
}
