package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.EspacosRequest;
import br.edu.ufape.reu.controller.dto.response.EspacosResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class EspacosController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("espacos")
	public List<EspacosResponse> getAllEspacos() {
		return facade.getAllEspacos()
			.stream()
			.map(EspacosResponse::new)
			.toList();
	}
	
	@PostMapping("espacos")
	public EspacosResponse createEspacos(@Valid @RequestBody EspacosRequest newObj) {
		return new EspacosResponse(facade.saveEspacos(newObj.convertToEntity()));
	}
	
	@GetMapping("espacos/{id}")
	public EspacosResponse getEspacosById(@PathVariable Long id) {
		try {
			return new EspacosResponse(facade.findEspacosById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Espacos " + id + " not found.");
		}
	}
	
	@PatchMapping("espacos/{id}")
	public EspacosResponse updateEspacos(@PathVariable Long id, @Valid @RequestBody EspacosRequest obj) {
		try {
			//Espacos o = obj.convertToEntity();
			Espacos oldObject = facade.findEspacosById(id);

			TypeMap<EspacosRequest, Espacos> typeMapper = modelMapper
													.typeMap(EspacosRequest.class, Espacos.class)
													.addMappings(mapper -> mapper.skip(Espacos::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new EspacosResponse(facade.updateEspacos(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("espacos/{id}")
	public String deleteEspacos(@PathVariable Long id) {
		try {
			facade.deleteEspacos(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
