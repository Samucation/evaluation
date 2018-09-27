package br.com.codeit.airlines.evaluation.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.codeit.airlines.evaluation.annotations.Motorista;

@Motorista
public class Piloto extends Tripulante {

	private static final long serialVersionUID = -323706955966512906L;
	
	@JsonCreator
	public Piloto(@JsonProperty("nome") String nome) {
		super(nome);
	}
	
}
