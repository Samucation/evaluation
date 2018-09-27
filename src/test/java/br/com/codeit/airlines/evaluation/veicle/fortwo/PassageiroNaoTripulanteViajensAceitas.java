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
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassageiroNaoTripulanteViajensAceitas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Policial Jhoe");
		listaPassageiros.add(policial);
		
		Presidiario presidiario = new Presidiario("Presidiario Billie");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiário pode embarcar com um motorista que seja policial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se policial e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica se policial e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Policial Jhoe");
		listaPassageiros.add(policial);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar com um motorista que seja policial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se policial e piloto não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica se policial e piloto não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisChefeDeVoo() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Policial Jhoe");
		listaPassageiros.add(policial);
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Tommy");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se chefeVoo pode embarcar com um motorista que seja policial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		//Verifica se policial e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
        //Verifica se policial e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, chefeVoo, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisComissario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Policial Jhoe");
		listaPassageiros.add(policial);
		
		Comissario comissario = new Comissario("Comissário Brian");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		//Verifica se comissario pode embarcar com um motorista que seja policial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		//Verifica se policial e comissario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
        //Verifica se policial e comissario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, comissario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisOficial() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Policial Jhoe");
		listaPassageiros.add(policial);
		
		Oficial oficial = new Oficial("Oficial Jason");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica se oficial pode embarcar com um motorista que seja policial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		//Verifica se policial e oficial não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
        //Verifica se policial e oficial não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, oficial, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
}
