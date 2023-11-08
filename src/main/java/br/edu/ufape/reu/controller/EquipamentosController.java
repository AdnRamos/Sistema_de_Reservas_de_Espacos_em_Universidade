package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.EquipamentosRequest;
import br.edu.ufape.reu.controller.dto.response.EquipamentosResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class EquipamentosController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("equipamentos")
	public List<EquipamentosResponse> getAllEquipamentos() {
		return facade.getAllEquipamentos()
			.stream()
			.map(EquipamentosResponse::new)
			.toList();
	}
	
	@PostMapping("equipamentos")
	public EquipamentosResponse createEquipamentos(@Valid @RequestBody EquipamentosRequest newObj) {
		return new EquipamentosResponse(facade.saveEquipamentos(newObj.convertToEntity()));
	}
	
	@GetMapping("equipamentos/{id}")
	public EquipamentosResponse getEquipamentosById(@PathVariable Long id) {
		try {
			return new EquipamentosResponse(facade.findEquipamentosById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamentos " + id + " not found.");
		}
	}
	
	@PatchMapping("equipamentos/{id}")
	public EquipamentosResponse updateEquipamentos(@PathVariable Long id, @Valid @RequestBody EquipamentosRequest obj) {
		try {
			//Equipamentos o = obj.convertToEntity();
			Equipamentos oldObject = facade.findEquipamentosById(id);

			TypeMap<EquipamentosRequest, Equipamentos> typeMapper = modelMapper
													.typeMap(EquipamentosRequest.class, Equipamentos.class)
													.addMappings(mapper -> mapper.skip(Equipamentos::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new EquipamentosResponse(facade.updateEquipamentos(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("equipamentos/{id}")
	public String deleteEquipamentos(@PathVariable Long id) {
		try {
			facade.deleteEquipamentos(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
