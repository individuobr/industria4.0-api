package br.edu.unicid.api.business;

import org.springframework.http.HttpStatus;

import br.edu.unicid.api.domain.Bagagem;

@FunctionalInterface
public interface IBagagemBusiness {

	HttpStatus cadastrarPassagerio(Bagagem bagagem);
	
	

}
