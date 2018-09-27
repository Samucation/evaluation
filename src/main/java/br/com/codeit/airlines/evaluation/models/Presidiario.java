package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Presidiario extends Passageiro {

	private static final long serialVersionUID = 8435783479262087269L;

	@JsonCreator
	public Presidiario(@JsonProperty("nome") String nome) {
		super(nome);
	}

}
