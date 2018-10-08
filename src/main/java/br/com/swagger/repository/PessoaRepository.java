package br.com.swagger.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.swagger.entity.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>  {

}
