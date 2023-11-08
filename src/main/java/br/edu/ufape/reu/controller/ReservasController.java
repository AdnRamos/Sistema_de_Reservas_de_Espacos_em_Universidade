package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.ReservasRequest;
import br.edu.ufape.reu.controller.dto.response.ReservasResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class ReservasController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("reservas")
	public List<ReservasResponse> getAllReservas() {
		return facade.getAllReservas()
			.stream()
			.map(ReservasResponse::new)
			.toList();
	}
	
	@PostMapping("reservas")
	public ReservasResponse createReservas(@Valid @RequestBody ReservasRequest newObj) {
		return new ReservasResponse(facade.saveReservas(newObj.convertToEntity()));
	}
	
	@GetMapping("reservas/{id}")
	public ReservasResponse getReservasById(@PathVariable Long id) {
		try {
			return new ReservasResponse(facade.findReservasById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservas " + id + " not found.");
		}
	}
	
	@PatchMapping("reservas/{id}")
	public ReservasResponse updateReservas(@PathVariable Long id, @Valid @RequestBody ReservasRequest obj) {
		try {
			//Reservas o = obj.convertToEntity();
			Reservas oldObject = facade.findReservasById(id);

			TypeMap<ReservasRequest, Reservas> typeMapper = modelMapper
													.typeMap(ReservasRequest.class, Reservas.class)
													.addMappings(mapper -> mapper.skip(Reservas::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new ReservasResponse(facade.updateReservas(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("reservas/{id}")
	public String deleteReservas(@PathVariable Long id) {
		try {
			facade.deleteReservas(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
