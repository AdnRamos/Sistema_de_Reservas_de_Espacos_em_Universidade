package br.edu.ufape.reu.controller.dto.request;

import org.modelmapper.ModelMapper;

import br.edu.ufape.reu.config.SpringApplicationContext;
import br.edu.ufape.reu.model.Penalidades;
import br.edu.ufape.reu.model.Reservas;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PenalidadesRequest {

  private Long id;
  private Reservas reserva;
  private String justificativa;
  

  public Penalidades convertToEntity(){
    ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
    Penalidades obj = modelMapper.map(this, Penalidades.class);
    return obj;  
  }
}
