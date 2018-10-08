package br.com.swagger.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.swagger.entity.Cargo;



public interface CargoRepository  extends CrudRepository<Cargo, Long>  {

}
