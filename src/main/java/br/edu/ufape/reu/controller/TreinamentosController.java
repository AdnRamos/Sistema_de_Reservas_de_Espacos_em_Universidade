package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.Treinamentos;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.TreinamentosRequest;
import br.edu.ufape.reu.controller.dto.response.TreinamentosResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class TreinamentosController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("treinamentos")
	public List<TreinamentosResponse> getAllTreinamentos() {
		return facade.getAllTreinamentos()
			.stream()
			.map(TreinamentosResponse::new)
			.toList();
	}
	
	@PostMapping("treinamentos")
	public TreinamentosResponse createTreinamentos(@Valid @RequestBody TreinamentosRequest newObj) {
		return new TreinamentosResponse(facade.saveTreinamentos(newObj.convertToEntity()));
	}
	
	@GetMapping("treinamentos/{id}")
	public TreinamentosResponse getTreinamentosById(@PathVariable Long id) {
		try {
			return new TreinamentosResponse(facade.findTreinamentosById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Treinamentos " + id + " not found.");
		}
	}
	
	@PatchMapping("treinamentos/{id}")
	public TreinamentosResponse updateTreinamentos(@PathVariable Long id, @Valid @RequestBody TreinamentosRequest obj) {
		try {
			//Treinamentos o = obj.convertToEntity();
			Treinamentos oldObject = facade.findTreinamentosById(id);

			TypeMap<TreinamentosRequest, Treinamentos> typeMapper = modelMapper
													.typeMap(TreinamentosRequest.class, Treinamentos.class)
													.addMappings(mapper -> mapper.skip(Treinamentos::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new TreinamentosResponse(facade.updateTreinamentos(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("treinamentos/{id}")
	public String deleteTreinamentos(@PathVariable Long id) {
		try {
			facade.deleteTreinamentos(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
