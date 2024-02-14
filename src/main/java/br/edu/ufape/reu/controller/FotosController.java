package br.edu.ufape.reu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ufape.reu.controller.dto.request.EspacosRequest;
import br.edu.ufape.reu.controller.dto.request.FotosRequest;
import br.edu.ufape.reu.controller.dto.response.FotosResponse;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Fotos;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class FotosController {
  @Autowired
  private Facade facade;
  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("fotos")
  public List<FotosResponse> getAllFotos() {
    return facade.getAllFotos()
      .stream()
      .map(FotosResponse::new)
      .toList();
  }

  @PostMapping("fotos")
  public FotosResponse createFotos(@Valid @RequestBody FotosRequest newObj) {
    return new FotosResponse(facade.saveFotos(newObj.convertToEntity()));
  }
  
  @GetMapping("fotos/{id}")
  public FotosResponse getFotosById(@PathVariable Long id) {
    try {
      return new FotosResponse(facade.findFotosById(id));
    } catch (RuntimeException ex) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fotos " + id + " not found.");
    }
  }
  @PatchMapping("fotos/{id}")
  public FotosResponse updateFotos(@PathVariable Long id, @Valid @RequestBody FotosRequest obj) {
    try {
      //Fotos o = obj.convertToEntity();
      Fotos oldObject = facade.findFotosById(id);
      
//			TypeMap<FotosRequest, Fotos> typeMapper = modelMapper
//													.typeMap(FotosRequest.class, Fotos.class)
//													.addMappings(mapper -> mapper.skip(Fotos::setId));
//
//
//			typeMapper.map(obj, oldObject);
      return new FotosResponse(facade.updateFotos(oldObject));
    } catch (RuntimeException ex) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
    }
  }

  @DeleteMapping("fotos/{id}")
  public String deleteFotos(@PathVariable Long id){
    try{
      facade.deleteFotos(id);
      return "";
    }catch(RuntimeException ex){
      throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
    }
  }
  
}
