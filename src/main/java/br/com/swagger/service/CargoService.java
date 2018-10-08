package br.com.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.swagger.entity.Cargo;
import br.com.swagger.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repo;
	
	
	
	public List<Cargo> obterTodos(){
		
		return repo.findAll();
	}

	
	public Cargo obterPorId(Long id){
		
		return repo.findById(id).get(); 
	}

	
	public void salvar( Cargo obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	
	public void excluirPorObj(Cargo obj) {		
		repo.delete(obj);
	}
	
	
	public void atualizarPorObj (Cargo obj) {
		repo.save(obj);
	}
	
	
	public void atualizarPorId (Long id) {
		
		repo.save(repo.findById(id).get());
	}
	
	
	public void excluirPorId (Long id) {
		
		repo.delete(repo.findById(id).get());
	}
	
	
	
}
