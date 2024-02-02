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

import br.edu.ufape.reu.controller.dto.request.DepartamentosRequest;
import br.edu.ufape.reu.controller.dto.response.DepartamentosResponse;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Departamentos;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
public class DepartamentosController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("departamentos")
	public List<DepartamentosResponse> getAllDepartamentos() {
		return facade.getAllDepartamentos()
			.stream()
			.map(DepartamentosResponse::new)
			.toList();
	}

	@PostMapping("departamentos")
	public DepartamentosResponse createDepartamentos(@Valid @RequestBody DepartamentosRequest newObj) {
		return new DepartamentosResponse(facade.saveDepartamentos(newObj.convertToEntity()));
	}

	@GetMapping("departamentos/{id}")
	public DepartamentosResponse getDepartamentosById(@PathVariable Long id) {
		try {
			return new DepartamentosResponse(facade.findDepartamentosById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamentos " + id + " not found.");
		}
	}

	@PatchMapping("departamentos/{id}")
	public DepartamentosResponse updateDepartamentos(@PathVariable Long id, @Valid @RequestBody DepartamentosRequest obj) {
		try {
			//Departamentos o = obj.convertToEntity();
			Departamentos oldObject = facade.findDepartamentosById(id);

			TypeMap<DepartamentosRequest, Departamentos> typeMapper = modelMapper
													.typeMap(DepartamentosRequest.class, Departamentos.class)
													.addMappings(mapper -> mapper.skip(Departamentos::setId));


			typeMapper.map(obj, oldObject);
			return new DepartamentosResponse(facade.updateDepartamentos(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}

	@DeleteMapping("departamentos/{id}")
	public String deleteDepartamentos(@PathVariable Long id) {
		try {
			facade.deleteDepartamentos(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}


}
