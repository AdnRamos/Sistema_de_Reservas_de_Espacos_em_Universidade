package br.edu.ufape.reu.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.Departamentos;
import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Fotos;
import br.edu.ufape.reu.model.Penalidades;
import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.model.Disponibilidade;
import br.edu.ufape.reu.model.Usuarios;
import br.edu.ufape.reu.service.DepartamentosService;
import br.edu.ufape.reu.service.EquipamentosService;
import br.edu.ufape.reu.service.EspacosService;
import br.edu.ufape.reu.service.FotosService;
import br.edu.ufape.reu.service.PenalidadesService;
import br.edu.ufape.reu.service.ReservasService;
import br.edu.ufape.reu.service.RestricoesHorarioService;
import br.edu.ufape.reu.service.UsuariosService;

@Service
public class Facade {
	//Usuarios--------------------------------------------------------------
	@Autowired
	private UsuariosService  usuariosService;

	public Usuarios saveUsuarios(Usuarios newInstance) {
		return usuariosService.saveUsuarios(newInstance);
	}

	public Usuarios updateUsuarios(Usuarios transientObject) {
		return usuariosService.updateUsuarios(transientObject);
	}

	public Usuarios findUsuariosById(long id) {
		return usuariosService.findUsuariosById(id);
	}

	public List<Usuarios> getAllUsuarios() {
		return usuariosService.getAllUsuarios();
	}

	public void deleteUsuarios(Usuarios persistentObject) {
		usuariosService.deleteUsuarios(persistentObject);
	}

	public void deleteUsuarios(long id) {
		usuariosService.deleteUsuarios(id);
	}


	//Disponibilidade--------------------------------------------------------------
	@Autowired
	private RestricoesHorarioService  disponibilidadeService;

	public Disponibilidade saveRestricoesHorario(Disponibilidade newInstance) {
		return disponibilidadeService.saveRestricoesHorario(newInstance);
	}

	public Disponibilidade updateRestricoesHorario(Disponibilidade transientObject) {
		return disponibilidadeService.updateRestricoesHorario(transientObject);
	}

	public Disponibilidade findRestricoesHorarioById(long id) {
		return disponibilidadeService.findRestricoesHorarioById(id);
	}

	public List<Disponibilidade> getAllRestricoesHorario() {
		return disponibilidadeService.getAllRestricoesHorario();
	}

	public void deleteRestricoesHorario(Disponibilidade persistentObject) {
		disponibilidadeService.deleteRestricoesHorario(persistentObject);
	}

	public void deleteRestricoesHorario(long id) {
		disponibilidadeService.deleteRestricoesHorario(id);
	}


	//Departamentos--------------------------------------------------------------
	@Autowired
	private DepartamentosService  departamentosService;

	public Departamentos saveDepartamentos(Departamentos newInstance) {
		return departamentosService.saveDepartamentos(newInstance);
	}

	public Departamentos updateDepartamentos(Departamentos transientObject) {
		return departamentosService.updateDepartamentos(transientObject);
	}

	public Departamentos findDepartamentosById(long id) {
		return departamentosService.findDepartamentosById(id);
	}

	public List<Departamentos> getAllDepartamentos() {
		return departamentosService.getAllDepartamentos();
	}

	public void deleteDepartamentos(Departamentos persistentObject) {
		departamentosService.deleteDepartamentos(persistentObject);
	}

	public void deleteDepartamentos(long id) {
		departamentosService.deleteDepartamentos(id);
	}


	//Equipamentos--------------------------------------------------------------
	@Autowired
	private EquipamentosService  equipamentosService;

	public Equipamentos saveEquipamentos(Equipamentos newInstance) {
		return equipamentosService.saveEquipamentos(newInstance);
	}

	public Equipamentos updateEquipamentos(Equipamentos transientObject) {
		return equipamentosService.updateEquipamentos(transientObject);
	}

	public Equipamentos findEquipamentosById(long id) {
		return equipamentosService.findEquipamentosById(id);
	}

	public List<Equipamentos> getAllEquipamentos() {
		return equipamentosService.getAllEquipamentos();
	}

	public void deleteEquipamentos(Equipamentos persistentObject) {
		equipamentosService.deleteEquipamentos(persistentObject);
	}

	public void deleteEquipamentos(long id) {
		equipamentosService.deleteEquipamentos(id);
	}


	//Espacos--------------------------------------------------------------
	@Autowired
	private EspacosService  espacosService;

	public Espacos saveEspacos(Espacos newInstance) {
		return espacosService.saveEspacos(newInstance);
	}

	public Espacos updateEspacos(Espacos transientObject) {
		return espacosService.updateEspacos(transientObject);
	}

	public Espacos findEspacosById(long id) {
		return espacosService.findEspacosById(id);
	}

	public List<Espacos> getAllEspacos() {
		return espacosService.getAllEspacos();
	}

	public void deleteEspacos(Espacos persistentObject) {
		espacosService.deleteEspacos(persistentObject);
	}

	public void deleteEspacos(long id) {
		espacosService.deleteEspacos(id);
	}


	//Reservas--------------------------------------------------------------
	@Autowired
	private ReservasService reservasService;

	public Reservas saveReservas(Reservas newInstance) {
		return reservasService.saveReservas(newInstance);
	}

	public Reservas updateReservas(Reservas transientObject) {
		return reservasService.updateReservas(transientObject);
	}

	public Reservas findReservasById(long id) {
		return reservasService.findReservasById(id);
	}

	public List<Reservas> getAllReservas() {
		return reservasService.getAllReservas();
	}

	public void deleteReservas(Reservas persistentObject) {
		reservasService.deleteReservas(persistentObject);
	}

	public void deleteReservas(long id) {
		reservasService.deleteReservas(id);
	}

	//Penalidades--------------------------------------------------------------
	@Autowired
	private PenalidadesService  penalidadesService;
	
	public Penalidades savePenalidades(Penalidades newInstance){
		return penalidadesService.savePenalidades(newInstance);
	};

	public Penalidades updatePenalidades(Penalidades transientObject){
		return penalidadesService.updatePenalidades(transientObject);
	};

	public Penalidades findPenalidadesById(long id){
		return penalidadesService.findPenalidadesById(id);
	};

	public List<Penalidades> getAllPenalidades(){
		return penalidadesService.getAllPenalidades();
	};

  public void deletePenalidades(Penalidades persistentObject){
		penalidadesService.deletePenalidades(persistentObject);
	};

  public void deletePenalidades(long id){
		reservasService.deleteReservas(id);
	};

	//Fotos--------------------------------------------------------------

	@Autowired
	private FotosService  fotosService;

	public Fotos saveFotos(Fotos newInstance) {
		return fotosService.saveFotos(newInstance);
	}

	public Fotos updateFotos(Fotos transientObject) {
		return fotosService.updateFotos(transientObject);
	}

	public List<Fotos> getAllFotos() {
		return fotosService.getAllFotos();
	}	
	public Fotos findFotosById(long id) {
		return fotosService.findFotosById(id);
	}
	public void deleteFotos(Fotos persistentObject) {
		fotosService.deleteFotos(persistentObject);
	}
	public void deleteFotos(long id) {
		fotosService.deleteFotos(id);
	}
}