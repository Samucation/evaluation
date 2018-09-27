package br.com.codeit.airlines.evaluation.json.generator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.PassageirosRequisicaoRest;
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.models.Teste;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonTransformacoes {
	
	
	@Test
	public void serializeAnddeserializePassageiros() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		String passageiroPresidiarioJson = mapper.writeValueAsString(new Presidiario("Presidiario Billy the Kid"));
		String passageiroPolicialJson = mapper.writeValueAsString(new Policial("Policial Andrew"));
		String passageiroPilotoJson = mapper.writeValueAsString(new Piloto("Piloto Jholl"));
		String passageiroComissarioJson = mapper.writeValueAsString(new Comissario("Comissario Andy"));
		String passageiroChefeVooJson = mapper.writeValueAsString(new ChefeVoo("ChefeVoo Antony"));
		String passageiroOficialJson = mapper.writeValueAsString(new Oficial("Oficial Antony"));
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		listaPassageiros.add(new Comissario("Comissario Andy"));
		listaPassageiros.add(new Piloto("Piloto Jholl"));
		String passageirosRequisicaoRestJson = mapper.writeValueAsString(new PassageirosRequisicaoRest(new Oficial("Oficial Antony"), listaPassageiros));
		
		System.out.println("passageiroPresidiarioJson: " + passageiroPresidiarioJson);
		System.out.println("passageiroPolicialJson: " + passageiroPolicialJson);
		System.out.println("passageiroPilotoJson: " + passageiroPilotoJson);
		System.out.println("passageiroComissarioJson: " + passageiroComissarioJson);
		System.out.println("passageiroOficialJson: " + passageiroOficialJson);
		System.out.println("passageiroChefeVooJson: " + passageiroChefeVooJson);
		System.out.println("passageirosRequisicaoRest: " + passageirosRequisicaoRestJson);
		
		System.out.println("\nRecuperando objeto:");
		Passageiro passageiroPresidiario = mapper.readValue(passageiroPresidiarioJson, Presidiario.class);	
		Passageiro passageiroPolicial = mapper.readValue(passageiroPolicialJson, Policial.class);	
		Passageiro passageiroPiloto = mapper.readValue(passageiroPilotoJson, Piloto.class);	
		Passageiro passageiroComissario = mapper.readValue(passageiroComissarioJson, Comissario.class);	
		Passageiro passageiroOficial = mapper.readValue(passageiroOficialJson, Oficial.class);	
		Passageiro passageiroChefeVoo = mapper.readValue(passageiroChefeVooJson, ChefeVoo.class);	
		PassageirosRequisicaoRest passageirosRequisicaoRest = mapper.readValue(passageirosRequisicaoRestJson, PassageirosRequisicaoRest.class);	
		
		System.out.println("\nRecuperando objetos:");
		System.out.println("Passageiro recuperado Presidiario: " + passageiroPresidiario);
		System.out.println("Passageiro recuperado Presidiario: " + passageiroPresidiario.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado Policial: " + passageiroPolicial);
		System.out.println("Passageiro recuperado Policial: " + passageiroPolicial.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado Piloto: " + passageiroPiloto);
		System.out.println("Passageiro recuperado Piloto: " + passageiroPiloto.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado Comissario: " + passageiroComissario);
		System.out.println("Passageiro recuperado Comissario: " + passageiroComissario.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado ChefeVoo: " + passageiroChefeVoo);
		System.out.println("Passageiro recuperado ChefeVoo: " + passageiroChefeVoo.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado Oficial: " + passageiroOficial);
		System.out.println("Passageiro recuperado Oficial: " + passageiroOficial.getClass().getSimpleName());
		
		System.out.println("\nPassageiro recuperado PassageirosRequisicaoRest: " + passageirosRequisicaoRest);
		System.out.println("Passageiro recuperado PassageirosRequisicaoRest: " + passageirosRequisicaoRest.getClass().getSimpleName());
		
		System.out.println("Pause"); 
	}

	@Ignore
	public void deserialize() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		objectMapper.registerModule(module);

		PassageirosRequisicaoRest passageirosRequisicaoRest = objectMapper.readValue(
				"{\r\n" + 
				"  \"passageiro\": {\r\n" + 
				"    \"type\": \"presidiario\",\r\n" + 
				"    \"nome\": \"Billy the Kid\"\r\n" + 
				"  },\r\n" + 
				"  \"listaPassageiros\": [\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"policial\",\r\n" + 
				"      \"nome\": \"Policial Brian\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"chefeVoo\",\r\n" + 
				"      \"nome\": \"Chefe de voo Tommy\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"",
				PassageirosRequisicaoRest.class);

		System.out.println(passageirosRequisicaoRest);
		System.out.println("Pause");
		//assertEquals("car" , basketItem.getProduct());
		//assertEquals("car-01", basketItem.getCode());
		//assertEquals(1, basketItem.getAmount());
	}
	
	@Ignore
	public void deserializeTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		objectMapper.registerModule(module);

		Teste teste = objectMapper.readValue(
				"{\r\n" + 
				"  \"nome\": \"Samuel\",\r\n" + 
				"  \"senha\": \"Senha\"\r\n" + 
				"}",
				Teste.class);

		System.out.println(teste);
		System.out.println("Pause");
		//assertEquals("car" , basketItem.getProduct());
		//assertEquals("car-01", basketItem.getCode());
		//assertEquals(1, basketItem.getAmount());
	}
	
	@Ignore
	public void serializePassageiroRequisicaoRest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enableDefaultTyping();
		
		SimpleModule module = new SimpleModule();
		objectMapper.registerModule(module);
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		PassageirosRequisicaoRest passageirosRest = new PassageirosRequisicaoRest();
		passageirosRest.setPassageiro(new Policial("Policial Samuel"));
		
		listaPassageiros.add(new Piloto("Piloto Marcos"));
		listaPassageiros.add(new Presidiario("Presidiario Marcos"));
		
		passageirosRest.setListaPassageiros(listaPassageiros);
		
		
		
		String listaDeserializada = objectMapper.writeValueAsString(passageirosRest);
		
		System.out.println(listaDeserializada);
		System.out.println("Pause");
	}
	
}
