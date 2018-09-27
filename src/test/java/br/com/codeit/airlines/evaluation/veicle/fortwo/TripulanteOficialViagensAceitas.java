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

import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteOficialViagensAceitas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	@Test
	public void testaSeVeiculoAceitaOficialMaisPolicial() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial primeiroOficial = new Oficial("Oficial Antony");
		
		listaPassageiros.add(primeiroOficial);
		
		Policial policial = new Policial("Policial Sonia Tanimoto");
		
		//Verifica se oficial e policial não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		//Verifica se oficial e policial não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
        //Verifica oficial e policial não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaOficialMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial primeiroOficial = new Oficial("Oficial Antony");
		
		listaPassageiros.add(primeiroOficial);
		
		Piloto piloto = new Piloto("Policial Sonia Tanimoto");
		
		//Verifica se oficial e piloto não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se oficial e piloto não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica oficial e piloto não causam problemas na validação de regra de chefe de voo e oficial.
		chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	
	
	
	
	
}
