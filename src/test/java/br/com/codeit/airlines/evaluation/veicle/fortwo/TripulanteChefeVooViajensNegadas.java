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
import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteChefeVooViajensNegadas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeVooMaisOficial() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de Voo Andrew");
		Comissario primeiroComissario = new Comissario("Comissario Antony");
		Comissario segundoComissario = new Comissario("Comissário Math");
		
		listaPassageiros.add(chefeVoo);
		listaPassageiros.add(primeiroComissario);
		listaPassageiros.add(segundoComissario);
		
		Oficial oficial = new Oficial("Oficial Marcos Tanimoto");
		
		//Verifica se oficial e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica se oficial e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
        //Verifica oficial e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(2));
	}
	
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeDeVooMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Tommy");
		listaPassageiros.add(chefeVoo);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy the kid");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiario e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiario e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica presidiario e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(1));
	}
	
	
	
}
