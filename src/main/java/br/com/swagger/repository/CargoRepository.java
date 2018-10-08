package br.com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.swagger.entity.Cargo;



@Repository
public interface CargoRepository  extends JpaRepository<Cargo, Long>  {

}
