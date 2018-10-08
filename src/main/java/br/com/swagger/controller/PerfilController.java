package br.com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.swagger.entity.Perfil;
import br.com.swagger.service.PerfilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Perfis")
@RequestMapping(value =  "/perfis")
public class PerfilController {
	
	
	@Autowired
	private PerfilService service;
	
	
	
	
	
	@ApiOperation(value="Listas Todos os Perfis")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> obterLista(){
		
		List<Perfil> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	
	
	
	
	
	@ApiOperation(value="Obter um perfil por ID")
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Perfil> obterLista(@PathVariable Long id){
		
		Perfil obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	
	@ApiOperation(value="Cadastrar um Perfil de Usuário")
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Perfil> salvar(Perfil obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}

	
	
	
	
	@ApiOperation(value="Atualizar um Perfil através de um Objeto")
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Perfil> atualizarPorObj(Perfil obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	

	
	
	
	
	@ApiOperation(value="Atualizar Perfil através de um ID")
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarPorId(@PathVariable Long id){
		
		service.salvar(service.obterPorId(id));
		
        return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	@ApiOperation(value="Excluir um Perfil através de um objeto")
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorObj(Perfil obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	
	
	
	
	@ApiOperation(value="Ecluir um perfil através de um ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Perfil> excluirPorId(@PathVariable Long id){
		
		service.excluirPorId(id);
        return ResponseEntity.ok().build();
	}
	
	


}
