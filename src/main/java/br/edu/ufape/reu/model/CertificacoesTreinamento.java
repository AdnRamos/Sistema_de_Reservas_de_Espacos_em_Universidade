package br.edu.ufape.reu.model;

import java.util.*;
import java.math.*;
import java.time.LocalDate;

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
public  class CertificacoesTreinamento  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long id;
	private Long usuarioID;
	private String treinamentoID;
	private LocalDate dataObtencao;
	private LocalDate dataValidade;
	@ManyToMany
	@ToString.Exclude
	private List<Treinamentos> treinamentos; 

}