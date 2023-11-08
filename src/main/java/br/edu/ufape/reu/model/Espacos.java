package br.edu.ufape.reu.model;

import java.util.*;
import java.math.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public  class Espacos  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private String tipo;
	private int capacidade;
	private String equipamentosDisponiveis;
	private String fotos;
	private String horarioDisponivel;
	private Long departamentoID;
	@ManyToMany
	@ToString.Exclude
	private List<Equipamentos> equipamentos; 
	@ManyToMany
	@ToString.Exclude
	private List<Reservas> reservas; 
	@ManyToMany
	@ToString.Exclude
	private List<RestricoesHorario> restricoesHorario; 

}