package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Estado;
import br.com.fabricadeprogramador.repository.EstadoRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Getter @Setter
	private List<Estado> estados;
	
	@PostConstruct
	public void init() {
		
		setEstados(estadoRepository.findAll());
	}

}
