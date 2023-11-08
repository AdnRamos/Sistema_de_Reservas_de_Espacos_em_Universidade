package br.edu.ufape.reu.service;

import java.util.List;

import br.edu.ufape.reu.model.CertificacoesTreinamento;

public interface CertificacoesTreinamentoServiceInterface {
	CertificacoesTreinamento saveCertificacoesTreinamento(CertificacoesTreinamento o);
	CertificacoesTreinamento findCertificacoesTreinamentoById(long id);
	CertificacoesTreinamento updateCertificacoesTreinamento(CertificacoesTreinamento u);
	void deleteCertificacoesTreinamento(CertificacoesTreinamento u);
	void deleteCertificacoesTreinamento(long id);
	List<CertificacoesTreinamento> getAllCertificacoesTreinamento();
    
    

    
}