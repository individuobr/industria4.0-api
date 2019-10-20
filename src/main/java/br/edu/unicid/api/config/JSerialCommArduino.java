package br.edu.unicid.api.config;
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JSerialCommArduino {

	public static SerialPort arduinoPort = null;
	public static InputStream arduinoStream = null;
	public static int PACKET_SIZE_IN_BYTES = 8;
	
	@Autowired
	private PacketListener listener;

	@Bean
	public void iniciaArduino() {

		int len = SerialPort.getCommPorts().length;
		SerialPort serialPorts[] = new SerialPort[len];
		serialPorts = SerialPort.getCommPorts();

		for (int i = 0; i < len; i++) {

			String portName = serialPorts[i].getDescriptivePortName();
			System.out.println(serialPorts[i].getSystemPortName() + ": " + portName + ": " + i);

			arduinoPort = serialPorts[i];
			arduinoPort.openPort();
			System.out.println("connected to: " + portName + "[" + i + "]");
			break;

		}

		//PacketListener listener = new PacketListener();
		arduinoPort.addDataListener(this.listener);
		listener.cleanLastUID();
	}

}
