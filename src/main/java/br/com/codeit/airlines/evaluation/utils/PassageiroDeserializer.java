package br.com.codeit.airlines.evaluation.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.models.Presidiario;

public class PassageiroDeserializer extends StdDeserializer<Passageiro> {

	private static final long serialVersionUID = 5444739406675232035L;

	public PassageiroDeserializer()  {
		this(null);
	}
	
	public PassageiroDeserializer(Class<?> vc) {
		super(vc); 
	}

	@Override
	public Passageiro deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		JsonNode node = jp.getCodec().readTree(jp);
		String nome = node.get("nome").asText();
		String tipoPassageiro = node.get("@type").asText();
		
		System.out.println("Retorno: " + nome);
		
		if(tipoPassageiro.equals("policial")) {
			return new Policial(nome);
		} else if (tipoPassageiro.equals("presidiario")) {
			return new Presidiario(nome);
		}
		return null;
	}
}
