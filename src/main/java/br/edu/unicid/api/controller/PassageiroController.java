package br.edu.unicid.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.api.business.IPassageiroBusiness;
import br.edu.unicid.api.domain.Passageiro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Passageiro", tags = {"Table - passageiro"})
@RestController
@CrossOrigin
@RequestMapping("/passageiro")
public class PassageiroController {

	@Autowired
	private IPassageiroBusiness passageiroBusiness;
	
	@ApiOperation(value = "Cadastra um novo passageiro",
			notes = "Com ou sem Bagagem",
			response = Passageiro.class,
			responseContainer = "Ststus")
	@PostMapping("/cadastrar")
	public ResponseEntity<Passageiro> cadastrarPassagerio(@RequestBody Passageiro passageiro) {
		HttpStatus httpStatus = passageiroBusiness.cadastrarPassagerio(passageiro);
		return new ResponseEntity<Passageiro>(passageiro, httpStatus);
				
	}
}
