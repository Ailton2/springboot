package br.com.fabricadeprogramador.controller;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fabricadeprogramador.model.Cliente;
import br.com.fabricadeprogramador.model.Contato;
import br.com.fabricadeprogramador.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteController  {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Getter @Setter
	private List<Cliente> clientes;
	@Getter @Setter
	private Cliente cliente =new Cliente();
	@Getter @Setter
	private boolean modoEdicao =false; 
	
	@Getter @Setter
	private Contato contato = new Contato();
	
	
	


	@PostConstruct
	public void init() {
		setClientes(clienteRepository.buscarTodos());

	}
	
	public void salvar() {
		clienteRepository.save(cliente);
		if (!modoEdicao )
		clientes.add(cliente);
		cliente = new Cliente();
		modoEdicao=false;
	}
	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
		
	}
	public void editar(Cliente cliente) {
		setCliente(cliente);
		modoEdicao=true;
	}
	public void cancelar() {
		cliente =new Cliente();
		modoEdicao=false;
	}

	

	public void adicionarContato() {

	    contato.setCliente(cliente);
		cliente.getContatos().add(contato);
		contato =new Contato();
	}
	public void excluirContato(Contato contato) {

		cliente.getContatos().remove(contato);
	
	}









}
