package br.edu.ufape.reu.controller;

import java.time.LocalDate;
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

import br.edu.ufape.reu.controller.dto.request.ReservasRequest;
import br.edu.ufape.reu.controller.dto.response.EquipamentosResponse;
import br.edu.ufape.reu.controller.dto.response.ReservasResponse;
import br.edu.ufape.reu.enums.StatusReserva;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.service.HorarioReservadoException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins = "http://localhost:5173/" )
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
		try {
			return new ReservasResponse(facade.saveReservas(newObj.convertToEntity()));
		}catch(HorarioReservadoException exception) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage());
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Can't save reserva.");
		}
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
			Reservas oldObject = facade.findReservasById(id);

			TypeMap<ReservasRequest, Reservas> typeMapper = modelMapper
													.typeMap(ReservasRequest.class, Reservas.class)
													.addMappings(mapper -> mapper.skip(Reservas::setId))
													.addMappings(mapper -> mapper.skip(Reservas::setUsuario))
													.addMappings(mapper -> mapper.skip(Reservas::setEspaco));


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
			return "Deleted Successfully";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}

	@GetMapping("reservas/usuario/{idUsuario}")
	public List<ReservasResponse> listReservasUsuario(@PathVariable Long idUsuario) {
		return facade.findReservasUsuario(idUsuario)
			.stream()
			.map(ReservasResponse::new)
			.toList();
	}
}
