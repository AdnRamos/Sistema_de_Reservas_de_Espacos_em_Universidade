package br.edu.ufape.reu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.reu.model.RestricoesHorario;

@Repository
public interface RestricoesHorarioRepository extends JpaRepository<RestricoesHorario, Long> {



}