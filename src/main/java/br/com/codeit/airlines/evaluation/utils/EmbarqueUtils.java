package br.com.codeit.airlines.evaluation.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.codeit.airlines.evaluation.exceptions.ValidacaoExcetion;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.rules.ChefeComOficialRegra;
import br.com.codeit.airlines.evaluation.rules.PilotoComComissarioRegra;
import br.com.codeit.airlines.evaluation.rules.PresoComTribulanteRegra;
import br.com.codeit.airlines.evaluation.rules.VeiculoFotTwoRegra;

@Component
public class EmbarqueUtils {
	
	@Autowired VeiculoFotTwoRegra veiculoFotTwoRegra;
	@Autowired PilotoComComissarioRegra pilotoComComissarioRegra;
	@Autowired PresoComTribulanteRegra presoComTribulanteRegra;
	@Autowired ChefeComOficialRegra chefeComOficialRegra;
	
	
	public List<String> verificaAutorizacaoEmbarqueVeiculoForTwo(List<Passageiro> listaPassageiros,
												                 Passageiro passageiro) throws ValidacaoExcetion {
        List<String> listaMsgValidacoes = new ArrayList<>();
        verificaAutorizacaoEmbarquePlataforma(listaPassageiros, passageiro);
        
        //Verifica se pode ser transferido para dentro do carro, ** verifica se existe motorista e está dentro das 2 vagas do forTwo **.
        veiculoFotTwoRegra.verificaSePodeSerTransferido(listaPassageiros, passageiro, listaMsgValidacoes);
        
        chamaExcetion(listaMsgValidacoes);
        return listaMsgValidacoes;
	}
	
	public List<String> verificaAutorizacaoEmbarquePlataforma(List<Passageiro> listaPassageiros,
			                                                  Passageiro passageiro) throws ValidacaoExcetion {
		List<String> listaMsgValidacoes = new ArrayList<>();
		
		//Verifica se comissario e piloto não causam problemas na validação de regra de presidiario.
		presoComTribulanteRegra.verificaSePodeSerTransferido(listaPassageiros, passageiro, listaMsgValidacoes);
		//Verifica se comissario e piloto não causam problemas na validação de regra de comisário.
		pilotoComComissarioRegra.verificaSePodeSerTransferido(listaPassageiros, passageiro, listaMsgValidacoes);
        //Verifica comissario e piloto não causam problemas na validação de regra de chefe de voo e oficial.
        chefeComOficialRegra.verificaSePodeSerTransferido(listaPassageiros, passageiro, listaMsgValidacoes);
        
        chamaExcetion(listaMsgValidacoes);
        return listaMsgValidacoes;
	}
	
	private void chamaExcetion(List<String> listaMsgValidacoes) throws ValidacaoExcetion {
		if(!listaMsgValidacoes.isEmpty()) {
		   throw new ValidacaoExcetion(listaMsgValidacoes);
		}
	}

}
