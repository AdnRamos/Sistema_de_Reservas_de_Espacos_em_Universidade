package br.edu.ufape.reu.model;

import java.util.List;

import br.edu.ufape.reu.enums.TipoUsuario;
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
import jakarta.persistence.OneToMany;
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
public class Usuarios  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	
	@Column(length = 11)
	private String telefone;
	
	@Column(length = 50)
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	private TipoUsuario tipo;
	
	@OneToMany(mappedBy = "usuario")
	@ToString.Exclude
	private List<Reservas> reservas;
	
	@OneToMany
	@ToString.Exclude
	@JoinColumn(name="usuario_id")
	private List<Penalidades> penalidades;
}