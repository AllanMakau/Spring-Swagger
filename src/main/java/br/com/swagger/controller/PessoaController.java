package br.com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.swagger.entity.Perfil;
import br.com.swagger.entity.Pessoa;
import br.com.swagger.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins  = "http://localhost:4200")
@Api(tags = "Pessoas")
@RequestMapping(value = "/pessoas")
public class PessoaController {

	
	@Autowired
	private PessoaService service;
	
	
	
	@ApiOperation(value="Listas Todas as Pessoas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> obterLista(){
		
		List<Pessoa> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	
	
	
	@ApiOperation(value="Obter uma Pessoa Por ID")
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Pessoa> obterLista(@PathVariable Long id){
		
		Pessoa obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	@ApiOperation(value="Cadastrar uma nova pessoa")
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Pessoa> salvar(Pessoa obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}

	
	
	
	
	@ApiOperation(value="Atualizar Uma pessoa através de um objeto")
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> atualizarPorObj(Pessoa obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	

	
	
	
	@ApiOperation(value="atualizar uma Pessoa através de um ID")
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarPorId(@PathVariable Long id){
		
		service.salvar(service.obterPorId(id));
		
        return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	@ApiOperation(value="Excluir uma Pessoa através de um objeto")
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> excluirPorObj(Pessoa obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	@ApiOperation(value="Excluir uma Pessoa atraves de id")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorId(@PathVariable Long id){
		
		service.excluirPorId(id);
        return ResponseEntity.ok().build();
	}
	
	
	
}
