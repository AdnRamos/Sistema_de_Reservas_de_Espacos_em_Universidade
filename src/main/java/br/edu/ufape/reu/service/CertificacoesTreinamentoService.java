package br.edu.ufape.reu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.reu.model.CertificacoesTreinamento;
import br.edu.ufape.reu.repository.CertificacoesTreinamentoRepository;

@Service
public class CertificacoesTreinamentoService implements CertificacoesTreinamentoServiceInterface {
	@Autowired
	private CertificacoesTreinamentoRepository repository;


	@Override
	public CertificacoesTreinamento saveCertificacoesTreinamento(CertificacoesTreinamento newInstance) {
		return repository.save(newInstance);
	}

	@Override
	public CertificacoesTreinamento updateCertificacoesTreinamento(CertificacoesTreinamento transientObject) {
		return repository.save(transientObject);
	}

	@Override
	public CertificacoesTreinamento findCertificacoesTreinamentoById(long id) {
		return repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist CertificacoesTreinamento with id = " + id));
	}

	@Override
	public List<CertificacoesTreinamento> getAllCertificacoesTreinamento(){
		return repository.findAll();
	}

	@Override
	public void deleteCertificacoesTreinamento(CertificacoesTreinamento persistentObject){
		this.deleteCertificacoesTreinamento(persistentObject.getId());

	}

	@Override
	public void deleteCertificacoesTreinamento(long id){
		CertificacoesTreinamento obj = repository.findById(id).orElseThrow( () -> new RuntimeException("It doesn't exist CertificacoesTreinamento with id = " + id));
		repository.delete(obj);
	}



}