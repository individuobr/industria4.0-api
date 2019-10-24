package br.edu.unicid.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.api.business.IBagagemBusiness;
import br.edu.unicid.api.business.Impl.BagagemBusiness;
import br.edu.unicid.api.domain.Bagagem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Bagagem", tags = {"Table - bagagem"})
@RestController
@CrossOrigin
@RequestMapping("/bagagem")
public class BagagemController {
	
	@Autowired
	private BagagemBusiness bagagem;
	
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
	
	@ApiOperation(value = "Buscar bagagem pelo hashArduino")
	@GetMapping("/buscarhashArduino/{hash_arduino}")
	public ResponseEntity<Bagagem> buscarPorHashArduino(@PathVariable(value="hash_arduino") String hashArduino) {
		
		Bagagem bagagens = bagagem.buscarBagagem(hashArduino);
		return ResponseEntity.status(HttpStatus.OK).body(bagagens);
	}
	
	@ApiOperation(value = "Buscar todas as bagagens na esteira")
	@GetMapping("/esteira/all")
	public ResponseEntity<List<Bagagem>> buscaBagageNaEsteira(){
		return bagagemBusiness.buscaBagageNaEsteira();		
		
	}
	@ApiOperation(value = "Setar status da mala para 0")
	@PutMapping("/zerarStatus")
	public void zerarStatus() {

		bagagem.zerarStatusMala();
	}

}
