package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.codeit.airlines.evaluation.annotations.Motorista;

@Motorista
public class ChefeVoo extends Tripulante {

	private static final long serialVersionUID = -7954699792454490453L;

	@JsonCreator
	public ChefeVoo(@JsonProperty("nome") String nome) {
		super(nome);
	}

}
