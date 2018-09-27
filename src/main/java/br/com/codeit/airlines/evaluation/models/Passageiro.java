package br.com.codeit.airlines.evaluation.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
		  use =  JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY 
		  )
@JsonSubTypes({
    @Type(value = Piloto.class, name = "piloto"),
    @Type(value = Comissario.class, name = "comissario"),
    @Type(value = ChefeVoo.class, name = "chefeVoo"),
    @Type(value = Presidiario.class, name = "presidiario"),
    @Type(value = Policial.class, name = "policial"),
    @Type(value = Oficial.class, name = "oficial")
})
public abstract class Passageiro implements Serializable {

	private static final long serialVersionUID = -262184684374881100L;
	
	private String nome;
	
	
	public Passageiro() {
		
	}
	
	@JsonCreator
	public Passageiro(@JsonProperty("nome") String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passageiro [nome=" + nome + "]";
	}


}
