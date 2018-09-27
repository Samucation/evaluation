package br.com.codeit.airlines.evaluation.veicle.fortwo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteOficialViagensNegadas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	@Test
	public void testaSeVeiculoAceitaOficialMaisChefeVoo() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial primeiroOficial = new Oficial("Oficial Antony");
		Oficial segundoOficial = new Oficial("Oficial Math");
		
		listaPassageiros.add(primeiroOficial);
		listaPassageiros.add(segundoOficial);
		
		ChefeVoo chefeVoo = new ChefeVoo("ChefeVoo Sonia Tanimoto");
		
		//Verifica se oficial e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se oficial e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
        //Verifica oficial e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(2));
	}
	
	@Test
	public void testaSeVeiculoAceitaOficialMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Presidiario presidiario = new Presidiario("Presidiario Antony");
		ChefeVoo chefeVoo = new ChefeVoo("ChefeVoo Sonia Tanimoto");
		
		listaPassageiros.add(presidiario);
		listaPassageiros.add(chefeVoo);
		
		Oficial oficial = new Oficial("Oficial Math");
		
		//Verifica se oficial e presidiario e chefe de voo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica se oficial e presidiario e chefe de voo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica oficial e presidiario e chefe de voo não causam problemas na validação de regra de chefe de voo e oficial.
		chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(3));
	}
	
	
	
	
	
}
