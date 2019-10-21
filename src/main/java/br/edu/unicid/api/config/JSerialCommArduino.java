package br.edu.unicid.api.config;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fazecast.jSerialComm.SerialPort;

@Configuration
public class JSerialCommArduino {
	
	public static SerialPort arduinoPort = null;
	public static InputStream arduinoStream = null;
	public static int PACKET_SIZE_IN_BYTES = 8;

	@Autowired
	private PacketListener listener;

	public String iniciaArduino() {
		arduinoPort = SerialPort.getCommPorts()[0];
		;
		if (arduinoPort.openPort()) {
			arduinoPort.addDataListener(this.listener);
			listener.cleanLastUID();
			return "Arduino Conectado com Sucesso!!!";
		}
		return "Erro ao Conectar Arduino!!!";
	}

	public String desligarArduino() {
		if (arduinoPort.closePort()) {
			return "Arduino Desconectado com Sucesso!!!";
		}
		return "Erro ao Desconectar Arduino!!!";
	}

}
