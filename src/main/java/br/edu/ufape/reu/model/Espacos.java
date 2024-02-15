package br.edu.ufape.reu.model;

import java.util.List;

import br.edu.ufape.reu.enums.TipoEspaco;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Espacos  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private int capacidade;
	private String regrasEspecificas;
	@Enumerated(EnumType.ORDINAL)
	private TipoEspaco tipo;
	
	//analisar
		private String horarioDisponivel;
	
		@ManyToMany
		@ToString.Exclude
		private List<Disponibilidade> restricoesHorario;
	//
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamentos departamento;
	
	@OneToMany
	@ToString.Exclude
	@JoinColumn(name="espaco_id")
	private List<Fotos> fotos;
	
	@OneToMany
	@ToString.Exclude
	@JoinColumn(name="espaco_id")
	private List<Equipamentos> equipamentos;
	
	@OneToMany
	@ToString.Exclude
	@JoinColumn(name="espaco_id")
	private List<Reservas> reservas;

}