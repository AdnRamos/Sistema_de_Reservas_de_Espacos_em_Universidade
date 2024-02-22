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
import br.edu.ufape.reu.controller.dto.response.ReservasResponse;
import br.edu.ufape.reu.enums.StatusReserva;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.model.Penalidades;
import br.edu.ufape.reu.model.Reservas;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin (origins = "http://localhost:5173/" )
public class PenalidadesController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("penalidades/{idReserva}")
    public ReservasResponse createPenalidades(@PathVariable Long idReserva, @Valid @RequestBody PenalidadesRequest newObj) {
		Reservas oldObject = facade.findReservasById(idReserva);
		oldObject.setPenalidade(newObj.convertToEntity());
		oldObject.setStatus(StatusReserva.penalizado);
		return new ReservasResponse(facade.updateReservas(oldObject));
    }

	@PatchMapping("penalidades/{id}")
	public PenalidadesResponse updatePenalidades(@PathVariable Long id, @Valid @RequestBody PenalidadesRequest obj) {
		try {
			Penalidades oldObject = facade.findPenalidadesById(id);
			oldObject.setJustificativa(obj.getJustificativa());

			return new PenalidadesResponse(facade.updatePenalidades(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}

	@DeleteMapping("penalidades/{idReserva}")
	public String deletePenalidades(@PathVariable Long idReserva) {
		try {
			Reservas oldObject = facade.findReservasById(idReserva);

			facade.deletePenalidades(oldObject.getPenalidade().getId());
			
			oldObject.setPenalidade(null);
			facade.updateReservas(oldObject);
			
			return "Removido com sucesso.";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}

	}


}
