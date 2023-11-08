package br.edu.ufape.reu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.reu.model.Treinamentos;

@Repository
public interface TreinamentosRepository extends JpaRepository<Treinamentos, Long> {



}