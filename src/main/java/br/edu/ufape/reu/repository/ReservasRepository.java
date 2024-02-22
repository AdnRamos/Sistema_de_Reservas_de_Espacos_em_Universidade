package br.edu.ufape.reu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.reu.model.Reservas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {
	public List<Reservas> findByUsuarioId(long idUsuario);
	//para buscar pela dataHora deve buscar nos 4 casos: dataInicio no meio, dataFim no meio, dataInicio menor e DataFim maior e dataInicio maior e DataFim menor
	public List<Reservas> findByDataAndDataHoraInicioLessThanAndDataHoraTerminoGreaterThanAndEspacoId(LocalDate data, LocalTime horaTermino, LocalTime horaInicio,long espacoId);
	
}