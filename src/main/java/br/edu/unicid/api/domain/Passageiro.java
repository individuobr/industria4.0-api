package br.edu.unicid.api.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "passageiro")
public class Passageiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String assento;
	@JsonIgnore
	@Transient
	private List<Bagagem> bagagem;
	
	public Passageiro(Integer id, String nome, String assento, List<Bagagem> bagagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.assento = assento;
		this.bagagem = bagagem;
	}
	
	public Passageiro() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}
	public List<Bagagem> getBagagem() {
		return bagagem;
	}
	public void setBagagem(List<Bagagem> bagagem) {
		this.bagagem = bagagem;
	}
	
	public void acrescentarBagagem(Bagagem bagagem) {
		if(this.bagagem.isEmpty()) {
			this.bagagem = new ArrayList<Bagagem>();
		}
			this.bagagem.add(bagagem);
	}
	

}
