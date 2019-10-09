package br.edu.unicid.api.exception;

public class PassageiroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;


	public PassageiroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	
	public PassageiroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
