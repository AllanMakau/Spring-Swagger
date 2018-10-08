package br.com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.swagger.entity.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {

}
