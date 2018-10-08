package br.com.swagger.entity;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	
	
	
	public Cargo() {
		super();
	}
	

	public Cargo(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
