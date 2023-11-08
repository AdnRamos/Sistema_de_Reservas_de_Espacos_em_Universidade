package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.CertificacoesTreinamento;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.CertificacoesTreinamentoRequest;
import br.edu.ufape.reu.controller.dto.response.CertificacoesTreinamentoResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class CertificacoesTreinamentoController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("certificacoesTreinamento")
	public List<CertificacoesTreinamentoResponse> getAllCertificacoesTreinamento() {
		return facade.getAllCertificacoesTreinamento()
			.stream()
			.map(CertificacoesTreinamentoResponse::new)
			.toList();
	}
	
	@PostMapping("certificacoesTreinamento")
	public CertificacoesTreinamentoResponse createCertificacoesTreinamento(@Valid @RequestBody CertificacoesTreinamentoRequest newObj) {
		return new CertificacoesTreinamentoResponse(facade.saveCertificacoesTreinamento(newObj.convertToEntity()));
	}
	
	@GetMapping("certificacoesTreinamento/{id}")
	public CertificacoesTreinamentoResponse getCertificacoesTreinamentoById(@PathVariable Long id) {
		try {
			return new CertificacoesTreinamentoResponse(facade.findCertificacoesTreinamentoById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CertificacoesTreinamento " + id + " not found.");
		}
	}
	
	@PatchMapping("certificacoesTreinamento/{id}")
	public CertificacoesTreinamentoResponse updateCertificacoesTreinamento(@PathVariable Long id, @Valid @RequestBody CertificacoesTreinamentoRequest obj) {
		try {
			//CertificacoesTreinamento o = obj.convertToEntity();
			CertificacoesTreinamento oldObject = facade.findCertificacoesTreinamentoById(id);

			TypeMap<CertificacoesTreinamentoRequest, CertificacoesTreinamento> typeMapper = modelMapper
													.typeMap(CertificacoesTreinamentoRequest.class, CertificacoesTreinamento.class)
													.addMappings(mapper -> mapper.skip(CertificacoesTreinamento::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new CertificacoesTreinamentoResponse(facade.updateCertificacoesTreinamento(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("certificacoesTreinamento/{id}")
	public String deleteCertificacoesTreinamento(@PathVariable Long id) {
		try {
			facade.deleteCertificacoesTreinamento(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
