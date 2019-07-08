package br.com.fabricadeprogramador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;

	@JoinColumn
	@ManyToOne
	private Estado estado;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cliente" ,fetch = FetchType.EAGER)
	private List<Contato> contatos = new ArrayList<>();
	
	



}
