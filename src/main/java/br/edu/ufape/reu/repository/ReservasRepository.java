package br.edu.ufape.reu.repository;

import java.util.List;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.reu.model.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {

	

}