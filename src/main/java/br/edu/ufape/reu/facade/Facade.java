package br.edu.ufape.reu.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.CertificacoesTreinamento;
import br.edu.ufape.reu.model.Departamentos;
import br.edu.ufape.reu.model.Equipamentos;
import br.edu.ufape.reu.model.Espacos;
import br.edu.ufape.reu.model.Reservas;
import br.edu.ufape.reu.model.RestricoesHorario;
import br.edu.ufape.reu.model.Treinamentos;
import br.edu.ufape.reu.model.Usuarios;
import br.edu.ufape.reu.service.CertificacoesTreinamentoService;
import br.edu.ufape.reu.service.DepartamentosService;
import br.edu.ufape.reu.service.EquipamentosService;
import br.edu.ufape.reu.service.EspacosService;
import br.edu.ufape.reu.service.ReservasService;
import br.edu.ufape.reu.service.RestricoesHorarioService;
import br.edu.ufape.reu.service.TreinamentosService;
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


	//RestricoesHorario--------------------------------------------------------------
	@Autowired
	private RestricoesHorarioService  restricoesHorarioService;

	public RestricoesHorario saveRestricoesHorario(RestricoesHorario newInstance) {
		return restricoesHorarioService.saveRestricoesHorario(newInstance);
	}

	public RestricoesHorario updateRestricoesHorario(RestricoesHorario transientObject) {
		return restricoesHorarioService.updateRestricoesHorario(transientObject);
	}

	public RestricoesHorario findRestricoesHorarioById(long id) {
		return restricoesHorarioService.findRestricoesHorarioById(id);
	}

	public List<RestricoesHorario> getAllRestricoesHorario() {
		return restricoesHorarioService.getAllRestricoesHorario();
	}

	public void deleteRestricoesHorario(RestricoesHorario persistentObject) {
		restricoesHorarioService.deleteRestricoesHorario(persistentObject);
	}

	public void deleteRestricoesHorario(long id) {
		restricoesHorarioService.deleteRestricoesHorario(id);
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


	//Treinamentos--------------------------------------------------------------
	@Autowired
	private TreinamentosService  treinamentosService;

	public Treinamentos saveTreinamentos(Treinamentos newInstance) {
		return treinamentosService.saveTreinamentos(newInstance);
	}

	public Treinamentos updateTreinamentos(Treinamentos transientObject) {
		return treinamentosService.updateTreinamentos(transientObject);
	}

	public Treinamentos findTreinamentosById(long id) {
		return treinamentosService.findTreinamentosById(id);
	}

	public List<Treinamentos> getAllTreinamentos() {
		return treinamentosService.getAllTreinamentos();
	}

	public void deleteTreinamentos(Treinamentos persistentObject) {
		treinamentosService.deleteTreinamentos(persistentObject);
	}

	public void deleteTreinamentos(long id) {
		treinamentosService.deleteTreinamentos(id);
	}


	//CertificacoesTreinamento--------------------------------------------------------------
	@Autowired
	private CertificacoesTreinamentoService  certificacoesTreinamentoService;

	public CertificacoesTreinamento saveCertificacoesTreinamento(CertificacoesTreinamento newInstance) {
		return certificacoesTreinamentoService.saveCertificacoesTreinamento(newInstance);
	}

	public CertificacoesTreinamento updateCertificacoesTreinamento(CertificacoesTreinamento transientObject) {
		return certificacoesTreinamentoService.updateCertificacoesTreinamento(transientObject);
	}

	public CertificacoesTreinamento findCertificacoesTreinamentoById(long id) {
		return certificacoesTreinamentoService.findCertificacoesTreinamentoById(id);
	}

	public List<CertificacoesTreinamento> getAllCertificacoesTreinamento() {
		return certificacoesTreinamentoService.getAllCertificacoesTreinamento();
	}

	public void deleteCertificacoesTreinamento(CertificacoesTreinamento persistentObject) {
		certificacoesTreinamentoService.deleteCertificacoesTreinamento(persistentObject);
	}

	public void deleteCertificacoesTreinamento(long id) {
		certificacoesTreinamentoService.deleteCertificacoesTreinamento(id);
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
	private ReservasService  reservasService;

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


}