package br.edu.unicid.api.config;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;

import br.edu.unicid.api.business.Impl.BagagemBusiness;
import br.edu.unicid.api.domain.Bagagem;

@Component
public class PacketListener implements SerialPortPacketListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(PacketListener.class);
	@Autowired
	private BagagemBusiness business;
	
	public String lastUID;
	
	public void cleanLastUID () {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			    lastUID = "";
			  }
			}, 0, 10000);
	}

	@Override
	public int getListeningEvents() {
		return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
	}

	@Override
	public int getPacketSize() {
		return JSerialCommArduino.PACKET_SIZE_IN_BYTES;
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		byte[] newData = event.getReceivedData();
		String tagUID = new String(newData).split("\n", 2)[0].replaceAll("\\s+", "");
		int byteSize = 0;
		try {
			byteSize = tagUID.getBytes("UTF-8").length;
		} catch (UnsupportedEncodingException ex) {
			LOGGER.error("Erro ao converter Bytes"+ex);;	
		}
		if (byteSize == JSerialCommArduino.PACKET_SIZE_IN_BYTES && !tagUID.equals(lastUID)) {
			// chamar endpoint de consulta de bagagem
			
			System.out.println(tagUID);
			Boolean resposta = business.buscarBagagemPorIdArduinoEAtualizaStatus(tagUID); 
			if(!resposta) {
				LOGGER.info("Bagagem Não Encontrada");
			}
		}
	}
	
}
