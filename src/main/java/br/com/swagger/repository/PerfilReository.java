package br.com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.swagger.entity.Perfil;


@Repository
public interface PerfilReository  extends JpaRepository<Perfil, Long> {

}
