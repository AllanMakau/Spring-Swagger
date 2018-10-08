package br.com.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.swagger.entity.Cargo;
import br.com.swagger.service.CargoService;

@RestController
@RequestMapping(value =  "/cargos")
public class CargoController {
	
	
	@Autowired
	private CargoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> obterLista(){
		
		List<Cargo> objcts =service.obterTodos();
        return ResponseEntity.ok(objcts);
	}
	
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Cargo> obterLista(@PathVariable Long id){
		
		Cargo obj =service.obterPorId(id);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Cargo> salvar(Cargo obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Cargo> atualizarPorObj(Cargo obj){
		
		service.salvar(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<Cargo> atualizarPorId(Long id){
		
		service.salvar(service.obterPorId(id));
        return ResponseEntity.ok().build();
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Cargo> excluirPorObj(Cargo obj){
		
		service.excluirPorObj(obj);
        return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping( method = RequestMethod.DELETE)
	public ResponseEntity<Cargo> excluirPorId(Long id){
		
		service.excluirPorId(id);
        return ResponseEntity.ok().build();
	}
	

}
