package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.codeit.airlines.evaluation.annotations.Motorista;

@Motorista
public class Policial extends Passageiro {

	private static final long serialVersionUID = -1957862910745141540L;
	
	public Policial(@JsonProperty("nome") String nome) {
		super(nome);
	}

}
