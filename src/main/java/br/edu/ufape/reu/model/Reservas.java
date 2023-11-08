package br.edu.ufape.reu.model;

import java.util.*;
import java.math.*;
import java.time.LocalDateTime;

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
public  class Reservas  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private Long UsuarioID;
	private Long espacoID;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraTermino;
	private String finalidade;
	private String status;
	@ManyToMany
	@ToString.Exclude
	private List<Usuarios> usuarios; 

}