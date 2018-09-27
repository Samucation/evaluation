package br.com.codeit.airlines.evaluation.rules;

import java.util.List;

import br.com.codeit.airlines.evaluation.models.Passageiro;

public interface Regra {

	boolean verificaSePodeSerTransferido(List<Passageiro> listaPassageiros, Passageiro novoPassageiro, List<String> listaMsgValidacoes);
	
	public static boolean tipoDePassageiroExisteNoLocal(List<Passageiro> listaPassageiros, Class novoPassageiro) {
		return listaPassageiros.stream().filter(p -> p.getClass().getTypeName().equals(novoPassageiro.getName())).count() > 0;
	}
}
