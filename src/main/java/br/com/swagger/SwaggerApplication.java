package br.com.swagger;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.swagger.entity.Cargo;
import br.com.swagger.entity.Perfil;
import br.com.swagger.repository.CargoRepository;
import br.com.swagger.repository.PerfilReository;
import br.com.swagger.repository.PessoaRepository;



@SpringBootApplication
public class SwaggerApplication implements CommandLineRunner{

	
	@Autowired
	private CargoRepository cargoRepo;
	
	@Autowired
	private PerfilReository perfilRepo;
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Cargo  c1 = new Cargo(null, "Analista de Crédito");
		Cargo  c2 = new Cargo(null, "Analista de Cobrança");
		Cargo  c3 = new Cargo(null, "Analista de RH");
		Cargo  c4 = new Cargo(null, "Analista de Financeiro");
		Cargo  c5 = new Cargo(null, "Gerente");
		Cargo  c6 = new Cargo(null, "Diretor");
		
		cargoRepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));
		
		Perfil p1 = new Perfil(null, "ADMINISTRADOR");
		Perfil p2 = new Perfil(null, "USUÁRIO");
		Perfil p3 = new Perfil(null, "VISITANTE");
		
		perfilRepo.saveAll(Arrays.asList(p1,p2,p3));

		
	}
}
