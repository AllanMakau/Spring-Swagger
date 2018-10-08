package br.com.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.swagger.entity.Perfil;
import br.com.swagger.repository.PerfilReository;

@Service
public class PerfilService {

	
	@Autowired
	private PerfilReository repo;
	
	
	public List<Perfil> obterTodos(){
		
		return repo.findAll();
	}

	
	public Perfil obterPorId(Long id){
		
		return repo.findById(id).get();
	}

	
	public void salvar( Perfil obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	
	public void excluirPorObj(Perfil obj) {		
		repo.delete(obj);
	}
	
	
	public void atualizarPorObj (Perfil obj) {
		repo.save(obj);
	}
	
	
	public void atualizarPorId (Long id) {
		
		repo.save(repo.findById(id).get());
	}
	
	
	public void excluirPorId (Long id) {
		
		repo.delete(repo.findById(id).get());
	}
	
}
