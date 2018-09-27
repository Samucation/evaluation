package br.com.codeit.airlines.evaluation.exceptions;

import java.util.List;

public class ValidacaoExcetion extends Exception {

	private static final long serialVersionUID = -5312308127312934244L;

	public ValidacaoExcetion(List<String> listaMsgValidacoes) {
        super(montaMsg(listaMsgValidacoes));
    }
	
	private static String montaMsg(List<String> listaMsgValidacoes) {
		String msgFormatada = "";
		String separador = System.getProperty("line.separator");
		for(String msgAtual:listaMsgValidacoes) {
			msgFormatada += separador + msgAtual;
		}
		return msgFormatada;
	}
}
