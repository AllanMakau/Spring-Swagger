package br.com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.swagger.entity.Perfil;
import br.com.swagger.entity.Pessoa;
import br.com.swagger.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> obterLista(){
		
		List<Pessoa> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Pessoa> obterLista(@PathVariable Long id){
		
		Pessoa obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Pessoa> salvar(Pessoa obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}

	
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> atualizarPorObj(Pessoa obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	

	
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarPorId(@PathVariable Long id){
		
		service.salvar(service.obterPorId(id));
		
        return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> excluirPorObj(Pessoa obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorId(@PathVariable Long id){
		
		service.excluirPorId(id);
        return ResponseEntity.ok().build();
	}
	
	
	
}
