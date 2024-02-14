package br.edu.ufape.reu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ufape.reu.controller.dto.request.EquipamentosRequest;
import br.edu.ufape.reu.controller.dto.response.EquipamentosResponse;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Equipamentos;
import jakarta.validation.Valid;


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

//			TypeMap<EquipamentosRequest, Equipamentos> typeMapper = modelMapper
//													.typeMap(EquipamentosRequest.class, Equipamentos.class)
//													.addMappings(mapper -> mapper.skip(Equipamentos::setId));
//
//
//			typeMapper.map(obj, oldObject);
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
