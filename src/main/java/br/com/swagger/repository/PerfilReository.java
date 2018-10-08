package br.com.swagger.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.swagger.entity.Perfil;

public interface PerfilReository  extends CrudRepository<Perfil, Long> {

}
