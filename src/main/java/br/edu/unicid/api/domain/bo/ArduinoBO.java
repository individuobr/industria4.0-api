package br.edu.unicid.api.domain.bo;

public class ArduinoBO {
	
	private String portName;
	private String portDescription;
	private Integer velocidade;
	
	public ArduinoBO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArduinoBO(String portName, String portDescription, Integer velocidade) {
		super();
		this.portName = portName;
		this.portDescription = portDescription;
		this.velocidade = velocidade;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getPortDescription() {
		return portDescription;
	}
	public void setPortDescription(String portDescription) {
		this.portDescription = portDescription;
	}
	public Integer getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}
	
	

}
