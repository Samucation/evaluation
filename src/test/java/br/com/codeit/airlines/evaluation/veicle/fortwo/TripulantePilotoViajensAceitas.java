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
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulantePilotoViajensAceitas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	@Test
	public void testaSeVeiculoAceitaCargaPilotoSozinho() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar sozinho no veículo.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto não causa problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica piloto não causa problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaPolicialMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Policial policial = new Policial("Piloto Jhoe");
		listaPassageiros.add(policial);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar com um motorista que seja policial.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto e policial não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica piloto e policial não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeDeVooMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Tommy");
		listaPassageiros.add(chefeVoo);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar com um motorista que seja chefe de voo.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto e chefeVoo não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica piloto e chefeVoo não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaOficialMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial oficial = new Oficial("Policial Jhoe");
		listaPassageiros.add(oficial);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar no veículo com oficial.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto e oficial não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica piloto e oficial não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(0));
	}
		
	
}
