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
import br.com.codeit.airlines.evaluation.models.Presidiario;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

/**
 * 
 * @author Samuel F Duarte
 * As validações contam a quantidade de erros de validação, sendo alternadas
 * entre 1 e dois erros dependendo do tipo de validação, se os dois tripulantes do 
 * veículo não são motoristas, então será 2 erros de validação, se ao menos um for
 * motorista, então retornará 1 erro de validação.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PassageiroNaoTripulanteViagensNegadas {

	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;

	
	@Test
	public void testaSeVeiculoAceitaCargaPilotoMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Piloto piloto = new Piloto("Piloto Marcos Fontes");
		listaPassageiros.add(piloto);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy The Kid");
		
		//Verifica se pode ser transferido para dentro do carro, se existe motorista.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiário pode embarcar com um motorista que não seja policial no caso Piloto.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se piloto e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica se piloto e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(1));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaChefeVooMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		ChefeVoo chefeVoo = new ChefeVoo("Chefe de voo Antony");
		listaPassageiros.add(chefeVoo);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy The Kid");
		
		//Verifica se pode ser transferido para dentro do carro, se existe motorista.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiário pode embarcar com um motorista que não seja policial no caso Chefe de voo.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se chefeVoo e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica se chefeVoo e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(1));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaComissarioMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Comissario comissario = new Comissario("Comissario de voo Brian");
		listaPassageiros.add(comissario);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy The Kid");
		
		//Verifica se pode ser transferido para dentro do carro, se existe motorista.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiário pode embarcar com um motorista que não seja policial no caso comissario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se comissario e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica se comissario e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(2));
	}
	
	@Test
	public void testaSeVeiculoAceitaCargaOficialMaisPresidiario() {
		
		List<Passageiro> listaPassageiros = new ArrayList<>();
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		Oficial oficial = new Oficial("Oficial de voo Math");
		listaPassageiros.add(oficial);
		
		Presidiario presidiario = new Presidiario("Presidiario Billy The Kid");
		
		//Verifica se pode ser transferido para dentro do carro, se existe motorista.
		veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se presidiário pode embarcar com um motorista que não seja policial no caso oficial.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		//Verifica se oficial e presidiario não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
        //Verifica se oficial e presidiario não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, presidiario, listaMsgValidacoes);
		
		assertThat(listaMsgValidacoes, hasSize(2));
	}
	
	
}
