package br.edu.unicid.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.api.business.IArduinoBuisiness;
import br.edu.unicid.api.domain.bo.ArduinoBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Arduino", tags = {"Configurações e Eventos Arduino"})
@RestController
@CrossOrigin
@RequestMapping("/arduino")
public class ArduinoController {
	
	@Autowired
	private IArduinoBuisiness arduinoBusiness;
	
	@ApiOperation(value = "Buscar bagagem pelo hashArduino")
	@GetMapping("/info")
	public ArduinoBO buscarInformacoes() {
		return arduinoBusiness.buscarInformacoes();
	}
	
	

}
