package br.com.codeit.airlines.evaluation.json.generator;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.PassageirosRequisicaoRest;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.models.Presidiario;

public class GerarJSONRest {
	
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Test
	public void gerarJSONArrayPassageiros() {
		String json = gson.toJson(getListaPassageiros());
		System.out.println("Mostrar:\n" + json);
	}
	
	private PassageirosRequisicaoRest getListaPassageiros() {
		PassageirosRequisicaoRest passageiroMaisLista = new PassageirosRequisicaoRest();
		
		passageiroMaisLista.setPassageiro(new Presidiario("Billy the Kid"));
		
		passageiroMaisLista.listaPassageiros.add(new Policial("Policial Brian"));
		passageiroMaisLista.listaPassageiros.add(new ChefeVoo("Chefe de voo Tommy"));
		
		return passageiroMaisLista;
	}

}
