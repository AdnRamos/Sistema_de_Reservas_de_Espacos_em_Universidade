package br.edu.ufape.reu.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.edu.ufape.reu.enums.StatusReserva;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"data","dataHoraInicio","dataHoraTermino","espaco_id"})})
public class Reservas  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String finalidade;
	
	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate data;
	
	@Column(columnDefinition = "TIME", nullable = false)
	private LocalTime dataHoraInicio;
	
	@Column(columnDefinition = "TIME", nullable = false)
	private LocalTime dataHoraTermino;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private StatusReserva status;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name="espaco_id", nullable = false)
	private Espacos espaco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="penalidade_id")
	private Penalidades penalidade;
}