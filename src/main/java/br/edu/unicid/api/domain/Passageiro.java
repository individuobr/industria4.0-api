package br.edu.unicid.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passageiro")
public class Passageiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String cpf;
	private String assento;
	private String voo;
		
	public Passageiro(Integer id, String nome, String cpf, String assento, String voo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.assento = assento;
		this.voo = voo;
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}

	public String getVoo() {
		return voo;
	}

	public void setVoo(String voo) {
		this.voo = voo;
	}
	

}
