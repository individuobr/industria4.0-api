package br.edu.unicid.api.business.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.edu.unicid.api.business.IBagagemBusiness;
import br.edu.unicid.api.domain.Bagagem;
import br.edu.unicid.api.domain.Passageiro;
import br.edu.unicid.api.exception.BagagemNaoEncontradaException;
import br.edu.unicid.api.exception.PassageiroNaoEncontradoException;
import br.edu.unicid.api.persistence.IBagagemRepository;

@Service
public class BagagemBusiness implements IBagagemBusiness{

private static final Logger LOGGER = LoggerFactory.getLogger(PassageiroBusiness.class);
	
	@Autowired
	private IBagagemRepository bagagemRepository;
	@Override
	public HttpStatus cadastrarPassagerio(Bagagem bagagem) {
		LOGGER.info("Cadastrando uma Nova Bagagem");
		HttpStatus httpStatus;
		try {
			bagagemRepository.save(bagagem);
			httpStatus = HttpStatus.ACCEPTED;
		} catch (HttpClientErrorException e) {
			LOGGER.error("Não foi possivel cadastra bagagem do Passageiro", e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return httpStatus;
	}
	
	public Bagagem buscarBagagem(String hashArduino) {
		Bagagem bagagem = bagagemRepository.buscarPorHashArduino(hashArduino);
		if(bagagem == null) {
			throw new BagagemNaoEncontradaException("O hashArduino da bagagem não pode ser encontrado!");
		}
		return bagagem;
	}
	
	public Bagagem buscarBagagemPorIdArduino(String hashArduino) {
		Bagagem bagagem;
		try {
			bagagem = bagagemRepository.findById(hashArduino).get();			
		} catch (HttpClientErrorException e) {
			bagagem = null;
			LOGGER.error("Não foi possivel localizar bagagem do Passageiro", e);			
		}
		return bagagem;
	}

	
	

}
