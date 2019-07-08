package br.com.fabricadeprogramador.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fabricadeprogramador.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestClienteRepository {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testsalvar() {
		Cliente cli =new Cliente("Joao","joao@ht.com");
		
		Cliente cliSalvar=clienteRepository.save(cli);
		Assert.assertNotNull(cliSalvar.getId());
		
	}
	
	@Test
	public void testBuscarporEmail() {
		Cliente cli =new Cliente("Joao","joao@ht.com");
		entityManager.persist(cli);
		Cliente cliencontrado =clienteRepository.buscarporEmail("joao@ht.com");
		
		assertThat(cliencontrado.getNome()).isEqualTo(cli.getNome());
		assertThat(cliencontrado.getEmail()).isEqualTo(cli.getEmail());
		
	}
	@Test
	public void testBuscarTodos() {
		Cliente cli =new Cliente("Joao","joao@ht.com");
		entityManager.persist(cli);	
		Cliente cliZe =new Cliente("ZE","ze@ht.com");
		entityManager.persist(cliZe);	
		
	//	List<Cliente> lista = clienteRepository.buscarTodos();
	}

}
