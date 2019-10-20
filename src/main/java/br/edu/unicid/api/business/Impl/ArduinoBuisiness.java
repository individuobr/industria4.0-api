package br.edu.unicid.api.business.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import br.edu.unicid.api.business.IArduinoBuisiness;
import br.edu.unicid.api.domain.bo.ArduinoBO;

@Service
public class ArduinoBuisiness implements IArduinoBuisiness{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArduinoBuisiness.class);
	
	@Override
	public ArduinoBO buscarInformacoes() {
		SerialPort serialPort = SerialPort.getCommPorts()[0];
		return montaObjetoArduinoBO(serialPort);		
	}
	
	private ArduinoBO montaObjetoArduinoBO(SerialPort serialPort){
		return new ArduinoBO(
				serialPort.getSystemPortName(), 
				serialPort.getPortDescription(), 
				serialPort.getBaudRate()
				);
	}

	@Override
	public void conectar() {
		LOGGER.info("Conectando Arduino...");
		
	}

	@Override
	public void descconectar() {
		LOGGER.info("Desconectando Arduino...");
		
	}

}
