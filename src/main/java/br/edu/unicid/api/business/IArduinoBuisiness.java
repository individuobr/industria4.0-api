package br.edu.unicid.api.business;

import br.edu.unicid.api.domain.bo.ArduinoBO;

public interface IArduinoBuisiness {
	
	public ArduinoBO buscarInformacoes();
	public void conectar();
	public void descconectar();

}
