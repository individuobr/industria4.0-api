package br.edu.unicid.api.exception;

public class BagagemNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;


	public BagagemNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
