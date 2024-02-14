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

import br.edu.ufape.reu.controller.dto.request.PenalidadesRequest;
import br.edu.ufape.reu.controller.dto.response.PenalidadesResponse;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Penalidades;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
public class PenalidadesController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("penalidades")
	public List<PenalidadesResponse> getAllPenalidades() {
		return facade.getAllPenalidades()
			.stream()
			.map(PenalidadesResponse::new)
			.toList();
	}

	@PostMapping("penalidades")
  public PenalidadesResponse createPenalidades(@Valid @RequestBody PenalidadesRequest newObj) {
    return new PenalidadesResponse(facade.savePenalidades(newObj.convertToEntity()));
  }
	
	@GetMapping("penalidades/{id}")
	public PenalidadesResponse getPenalidadesById(@PathVariable Long id) {
		try {
			return new PenalidadesResponse(facade.findPenalidadesById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Penalidade " + id + " not found.");
		}
	}

	@PatchMapping("penalidades/{id}")
	public PenalidadesResponse updatePenalidades(@PathVariable Long id, @Valid @RequestBody PenalidadesRequest obj) {
		try {
			//Penalidades o = obj.convertToEntity();
			Penalidades oldObject = facade.findPenalidadesById(id);

//			TypeMap<PenalidadesRequest, Penalidades> typeMapper = modelMapper
//													.typeMap(PenalidadesRequest.class, Penalidades.class)
//													.addMappings(mapper -> mapper.skip(Penalidades::setId));
//
//
//			typeMapper.map(obj, oldObject);
			return new PenalidadesResponse(facade.updatePenalidades(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}

	@DeleteMapping("penalidades/{id}")
	public String deletePenalidades(@PathVariable Long id) {
		try {
			facade.deletePenalidades(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}


}
