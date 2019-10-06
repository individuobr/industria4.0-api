package br.edu.unicid.api.business.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.edu.unicid.api.business.IPassageiroBusiness;
import br.edu.unicid.api.domain.Passageiro;
import br.edu.unicid.api.persistence.IPassageiroRepository;

@Service
public class PassageiroBusiness implements IPassageiroBusiness{

	private static final Logger LOGGER = LoggerFactory.getLogger(PassageiroBusiness.class);
	
	@Autowired
	private IPassageiroRepository passageiroRepository;
	
	@Override
	public HttpStatus cadastrarPassagerio(Passageiro passageiro) {
		LOGGER.info("Cadastrando um Novo Passageiro");
		HttpStatus httpStatus;
		try {
			passageiroRepository.save(passageiro);
			httpStatus = HttpStatus.ACCEPTED;
		} catch (HttpClientErrorException e) {
			LOGGER.error("Não foi possivel cadastra o Passageiro", e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return httpStatus;
	}

	@Override
	public ResponseEntity<Passageiro> buscarPassagerio(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
