package br.com.swagger.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.swagger.entity.Cargo;
import br.com.swagger.service.CargoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api(tags = "Cargos")
@RequestMapping(value =  "/cargos")
public class CargoController {
	
	
	@Autowired
	private CargoService service;
	
	
	
	
	@ApiOperation(value="Listas Todos os Cargos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> obterLista(){
		
		List<Cargo> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	
	
	
	@ApiOperation(value="Obter Cargo por ID")
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Cargo> obterLista(@PathVariable Long id){
		
		Cargo obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	
	
	@ApiOperation(value="Cadastrar um cargo")
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Cargo> salvar(@RequestBody Cargo obj){
		
		service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
	}
	
	
	
	
	@ApiOperation(value="Atualizar um cargo atraves de um objeto")
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Cargo> atualizarPorObj(@RequestBody Cargo obj){
		
		service.salvar(obj);
        return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	@ApiOperation(value="Atualizar um cargo atraves de um ID")
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarPorId(@PathVariable Long id){
		
		service.salvar(service.obterPorId(id));
        return ResponseEntity.noContent().build();
	}
	
	
	
	
	@ApiOperation(value="Excluir um cargo atraves de um objeto")
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Cargo> excluirPorObj(Cargo obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}

	

	

}
