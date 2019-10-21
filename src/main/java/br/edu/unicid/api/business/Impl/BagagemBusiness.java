package br.edu.unicid.api.business.Impl;

import java.util.Optional;

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
public class BagagemBusiness implements IBagagemBusiness {

	private static final Logger LOGGER = LoggerFactory.getLogger(BagagemBusiness.class);

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
		if (bagagem == null) {
			throw new BagagemNaoEncontradaException("O hashArduino da bagagem não pode ser encontrado!");
		}
		return bagagem;
	}

	/**
	 * Busca Bagagem pelo id e atualiza status
	 * 
	 * @param hashArduino
	 * @return
	 */
	public Boolean buscarBagagemPorIdArduinoEAtualizaStatus(String hashArduino) {

		try {
			Optional<Bagagem> optional = bagagemRepository.findById(hashArduino);
			// Valida se existe no banco
			if (optional.isPresent()) {
				Bagagem bagagem = optional.get();
				switch (bagagem.getStatus()) {
				case 0:
					bagagem.setStatus(1);
					bagagemRepository.saveAndFlush(bagagem);
					break;
				case 1:
					LOGGER.info("Bagagem continua na Esteira");
					break;
				case 2:
					LOGGER.info("Bagagem Ja saiu da na Esteira");
					break;
				default:
					break;
				}					
				return true;
			} else {
				return false;
			}
		} catch (HttpClientErrorException e) {
			LOGGER.error("Não foi possivel localizar bagagem do Passageiro", e);
			return false;
		}

	}

}
