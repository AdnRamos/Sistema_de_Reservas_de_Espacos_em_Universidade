package br.edu.ufape.reu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.reu.model.Usuarios;
import br.edu.ufape.reu.facade.Facade;
import br.edu.ufape.reu.controller.dto.request.UsuariosRequest;
import br.edu.ufape.reu.controller.dto.response.UsuariosResponse;


@CrossOrigin (origins = "http://localhost:8081/" )
@RestController
@RequestMapping("/api/v1/")
public class UsuariosController {
	@Autowired
	private Facade facade;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("usuarios")
	public List<UsuariosResponse> getAllUsuarios() {
		return facade.getAllUsuarios()
			.stream()
			.map(UsuariosResponse::new)
			.toList();
	}
	
	@PostMapping("usuarios")
	public UsuariosResponse createUsuarios(@Valid @RequestBody UsuariosRequest newObj) {
		return new UsuariosResponse(facade.saveUsuarios(newObj.convertToEntity()));
	}
	
	@GetMapping("usuarios/{id}")
	public UsuariosResponse getUsuariosById(@PathVariable Long id) {
		try {
			return new UsuariosResponse(facade.findUsuariosById(id));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuarios " + id + " not found.");
		}
	}
	
	@PatchMapping("usuarios/{id}")
	public UsuariosResponse updateUsuarios(@PathVariable Long id, @Valid @RequestBody UsuariosRequest obj) {
		try {
			//Usuarios o = obj.convertToEntity();
			Usuarios oldObject = facade.findUsuariosById(id);

			TypeMap<UsuariosRequest, Usuarios> typeMapper = modelMapper
													.typeMap(UsuariosRequest.class, Usuarios.class)
													.addMappings(mapper -> mapper.skip(Usuarios::setId));			
			
			
			typeMapper.map(obj, oldObject);	
			return new UsuariosResponse(facade.updateUsuarios(oldObject));
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	
	@DeleteMapping("usuarios/{id}")
	public String deleteUsuarios(@PathVariable Long id) {
		try {
			facade.deleteUsuarios(id);
			return "";
		} catch (RuntimeException ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
		
	}
	

}
