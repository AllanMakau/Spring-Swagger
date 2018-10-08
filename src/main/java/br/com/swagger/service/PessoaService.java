package br.com.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.swagger.entity.Pessoa;
import br.com.swagger.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	
	public List<Pessoa> obterTodos(){
		
		return repo.findAll();
	}

	
	public Pessoa obterPorId(Long id){
		
		return repo.findById(id).get();
	}

	
	public void salvar( Pessoa obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	
	public void excluirPorObj(Pessoa obj) {		
		repo.delete(obj);
	}
	
	
	public void atualizarPorObj (Pessoa obj) {
		repo.save(obj);
	}
	
	
	public void atualizarPorId (Long id) {
		
		repo.save(repo.findById(id).get());
	}
	
	
	public void excluirPorId (Long id) {
		
		repo.delete(repo.findById(id).get());
	}

}
