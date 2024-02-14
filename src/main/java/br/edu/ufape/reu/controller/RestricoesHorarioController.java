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

import br.edu.ufape.reu.controller.dto.request.RestricoesHorarioRequest;
import br.edu.ufape.reu.controller.dto.response.RestricoesHorarioResponse;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Disponibilidade;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
public class RestricoesHorarioController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("restricoesHorario")
	public List<RestricoesHorarioResponse> getAllRestricoesHorario() {
		return facade.getAllRestricoesHorario()
			.stream()
			.map(RestricoesHorarioResponse::new)
			.toList();
	}

	@PostMapping("restricoesHorario")
	public RestricoesHorarioResponse createRestricoesHorario(@Valid @RequestBody RestricoesHorarioRequest newObj) {
		return new RestricoesHorarioResponse(facade.saveRestricoesHorario(newObj.convertToEntity()));
	}

	@GetMapping("restricoesHorario/{id}")
	public RestricoesHorarioResponse getRestricoesHorarioById(@PathVariable Long id) {
		try {
			return new RestricoesHorarioResponse(facade.findRestricoesHorarioById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RestricoesHorario " + id + " not found.");
		}
	}

	@PatchMapping("restricoesHorario/{id}")
	public RestricoesHorarioResponse updateRestricoesHorario(@PathVariable Long id, @Valid @RequestBody RestricoesHorarioRequest obj) {
		try {
			//RestricoesHorario o = obj.convertToEntity();
			Disponibilidade oldObject = facade.findRestricoesHorarioById(id);

//			TypeMap<RestricoesHorarioRequest, Disponibilidade> typeMapper = modelMapper
//													.typeMap(RestricoesHorarioRequest.class, Disponibilidade.class)
//													.addMappings(mapper -> mapper.skip(Disponibilidade::setId));
//
//
//			typeMapper.map(obj, oldObject);
			return new RestricoesHorarioResponse(facade.updateRestricoesHorario(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}

	@DeleteMapping("restricoesHorario/{id}")
	public String deleteRestricoesHorario(@PathVariable Long id) {
		try {
			facade.deleteRestricoesHorario(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}


}
