package br.com.fabricadeprogramador.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.repository.UsuarioRepository;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
	http.userDetailsService(userDetailsService())
	.formLogin()
	.defaultSuccessUrl("/Cliente.jsf").and().csrf()
	.disable()
	.authorizeRequests()
	.anyRequest().authenticated();
	
	
	
		
	}

@Override
protected UserDetailsService userDetailsService() {
	
	List<Usuario> usuarios = UsuarioRepository.findAll();
	
	List<UserDetails> users =new ArrayList<>();
	for (Usuario u :usuarios) {
	UserDetails user = new User(u.getLogin(),u.getSenha(),AuthorityUtils.commaSeparatedStringToAuthorityList(u.getPapel()));
	users.add(user);
	 
	}		
	return new InMemoryUserDetailsManager(users);
}


}