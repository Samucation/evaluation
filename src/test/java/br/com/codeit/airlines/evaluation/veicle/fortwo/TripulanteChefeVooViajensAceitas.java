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
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteChefeVooViajensAceitas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeVooSozinho() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de Voo Andrew");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se chefeVoo não causa problemas na validação de regra de presidiario
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se chefeVoo não causa problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
        //Verifica chefeVoo não causa problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeVooMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de Voo Andrew");
		listaPassageiros.add(chefeVoo);
		
		Piloto piloto = new Piloto("Piloto Jhoe");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica piloto e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeDeVooMaisComissario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Tommy");
		listaPassageiros.add(chefeVoo);
		
		Comissario comissario = new Comissario("Comissario José");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		//Verifica se comissario e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		//Verifica se comissario e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
        //Verifica comissario e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeVooPolicial() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial oficial = new Oficial("Policial Jhoe");
		listaPassageiros.add(oficial);
		
		Policial policial = new Policial("Policial Crocoop");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		//Verifica se piloto e chefeVoo não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		//Verifica se piloto e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
        //Verifica piloto e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, policial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
		
	
}
