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
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteComissarioViagensPermitidas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	@Test
	public void testaSeVeiculoAceitaComissarioMaisChefeVoo() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario primeiroComissario = new Comissario("Comissario Antony");
		
		listaPassageiros.add(primeiroComissario);
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Sonia Tanimoto");
		
		//Verifica se comissario e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se comissario e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
        //Verifica comissario e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	
	@Test
	public void testaSeVeiculoAceitaCargaComissarioPolicial() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario primeiroComissario = new Comissario("Comissario Antony");
		
		listaPassageiros.add(primeiroComissario);
		
		Policial policial = new Policial("Policial Crocoop");
		
		//Verifica se comissario e policial não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		//Verifica se comissario e policial não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
        //Verifica comissario e policial não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	
	
}
