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

import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripulanteComissarioViagensNegadas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	@Test
	public void testaSeVeiculoAceitaComissarioMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario primeiroComissario = new Comissario("Comissario Antony");
		Comissario segundoComissario = new Comissario("Comissário Math");
		
		listaPassageiros.add(primeiroComissario);
		listaPassageiros.add(segundoComissario);
		
		Piloto piloto = new Piloto("Piloto Sonia Tanimoto");
		
		//Verifica se comissario e piloto não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se comissario e piloto não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
        //Verifica comissario e piloto não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(2));
	}
	
	
	@Test
	public void testaSeVeiculoAceitaCargaComissarioPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario primeiroComissario = new Comissario("Comissario Antony");
		Comissario segundoComissario = new Comissario("Comissário Math");
		
		listaPassageiros.add(primeiroComissario);
		listaPassageiros.add(segundoComissario);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy the Kid");
		
		//Verifica se comissario e presidiario não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se comissario e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica comissario e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(3));
	}
	
	
	
}
