package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Comissario extends Tripulante {

	private static final long serialVersionUID = -2333600345125415943L;

	@JsonCreator
	public Comissario(@JsonProperty("nome") String nome) {
		super(nome);
	}

}
