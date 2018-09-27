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
public class TripulantePilotoViajensNegadas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	@Test
	public void testaSeVeiculoAceitaCargaComissarioMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario comissario = new Comissario("Comissario Everlyn");
		listaPassageiros.add(comissario);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar com um comissário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);

		//Verifica se pode embarcar com presidiario
        presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
        
        //Verifica se pode embarcar com chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(1));
	}
	
	@Test
	public void testaSeVeiculoAceitaPresidiarioMaisPiloto() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Presidiario presidiario = new Presidiario("Presidiario de voo Tommy");
		listaPassageiros.add(presidiario);
		
		Piloto piloto = new Piloto("Piloto Math");
		
		//Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista **.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se piloto pode embarcar com umpresidiario.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		//Verifica se pode embarcar com presidiario
        presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
        
        //Verifica se pode embarcar com chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, piloto, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(1));
	}
	
}
