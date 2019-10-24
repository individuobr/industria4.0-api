package br.edu.unicid.api.business;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.unicid.api.domain.Bagagem;


public interface IBagagemBusiness {

	HttpStatus cadastrarPassagerio(Bagagem bagagem);

	ResponseEntity<List<Bagagem>> buscaBagageNaEsteira();
}
