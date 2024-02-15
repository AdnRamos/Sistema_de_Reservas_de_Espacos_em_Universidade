package br.edu.ufape.reu.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.edu.ufape.reu.enums.StatusReserva;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Reservas  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String finalidade;
	
	@Column(columnDefinition = "TIME")
	private LocalTime dataHoraInicio;
	
	@Column(columnDefinition = "TIME")
	private LocalTime dataHoraTermino;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusReserva status;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuarios usuario;
	
	@OneToOne
	private Penalidades penalidade;
}