package br.edu.unicid.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bagagem")
public class Bagagem {

	@Id
	private String hashArduino;
	private Float peso;
	private Integer idPassageiro;
	
	public Bagagem() {
	} 
	
	public Bagagem(String hashArduino, Float peso, Integer idPassageiro) {
		super();
		this.hashArduino = hashArduino;
		this.peso = peso;
		this.idPassageiro = idPassageiro;
	}

	public String getHashArduino() {
		return hashArduino;
	}
	public void setHashArduino(String hashArduino) {
		this.hashArduino = hashArduino;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Integer getIdPassageiro() {
		return idPassageiro;
	}

	public void setIdPassageiro(Integer idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	
	
	
}
