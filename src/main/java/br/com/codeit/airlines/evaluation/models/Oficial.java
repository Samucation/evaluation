package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Oficial extends Tripulante {

	private static final long serialVersionUID = -1336339645783835287L;
	
	@JsonCreator
	public Oficial(@JsonProperty("nome") String nome) {
		super(nome);
	}
	
	
}
