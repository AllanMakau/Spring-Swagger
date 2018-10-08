package br.com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.swagger.entity.Cargo;
import br.com.swagger.entity.Perfil;
import br.com.swagger.service.PerfilService;

@RestController
@RequestMapping(value =  "/perfis")
public class PerfilController {
	
	
	@Autowired
	private PerfilService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> obterLista(){
		
		List<Perfil> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Perfil> obterLista(@PathVariable Long id){
		
		Perfil obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Perfil> salvar(Perfil obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Perfil> atualizarPorObj(Perfil obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Perfil> atualizarPorId(Long id){
		
		service.salvar(service.obterPorId(id));
        return ResponseEntity.ok().build();
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorObj(Perfil obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorId(Long id){
		
		service.excluirPorId(id);
        return ResponseEntity.ok().build();
	}
	


}
