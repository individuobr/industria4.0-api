package br.edu.unicid.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.api.business.IBagagemBusiness;
import br.edu.unicid.api.domain.Bagagem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Bagagem", tags = {"Table - bagagem"})
@RestController
@CrossOrigin
@RequestMapping("/bagagem")
public class BagagemController {
	
	@Autowired
	private IBagagemBusiness bagagemBusiness;
	
	@ApiOperation(value = "Cadastra uma nova bagagem ao passageiro",
			notes = "",
			response = Bagagem.class,
			responseContainer = "object")
	@PostMapping("/cadastrar")
	public ResponseEntity<Bagagem> cadastrarBagagem(@RequestBody Bagagem bagagem) {
		HttpStatus httpStatus = bagagemBusiness.cadastrarPassagerio(bagagem);
		return new ResponseEntity<Bagagem>(bagagem, httpStatus);
				
	}

}
