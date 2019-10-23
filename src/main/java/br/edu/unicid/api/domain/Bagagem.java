package br.edu.unicid.api.domain;

import javax.persistence.Column;
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
	@Column(columnDefinition="COMMENT '0 = Bagagem não ainda não está na esterira, 1 = Bagagem está na esterira,2 = Bagagem Retirada.'")
	private Integer status; 
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
