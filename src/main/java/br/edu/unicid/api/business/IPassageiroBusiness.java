package br.edu.unicid.api.business;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.unicid.api.domain.Passageiro;

public interface IPassageiroBusiness {
	
	public HttpStatus cadastrarPassagerio(Passageiro passageiro);
	
	public ResponseEntity<Passageiro> buscarPassagerio(Integer id);
	
	

}
