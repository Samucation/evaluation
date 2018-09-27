package br.com.codeit.airlines.evaluation.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Piloto;
import br.com.codeit.airlines.evaluation.models.Policial;
import br.com.codeit.airlines.evaluation.models.Presidiario;

@Component
public class PresoComTribulanteRegra implements Regra {
	
	private static final String PRESIDIARIO = "Presidiario ";
	private static final String POLICIAL = "Policial ";
	private static final String MENSAGEM = "não pode ficar sozinho sem um ";

	@Override
	public boolean verificaSePodeSerTransferido(List<Passageiro> listaPassageiros, Passageiro novoPassageiro, List<String> listaMsgValidacoes) {
		
		if (novoPassageiro instanceof Presidiario) {
			//Se novo passageiro é um presidiario então ele só pode trafegar com um policial
			//Então presidiario pode embarcar uma vez que ele estará com um policial.
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Policial.class)) {
				return true;
			}
			//Se passageiro é um presidiário e não existe nenhum policial, então ele não pode embarcar.
			if (!Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Policial.class)) {
				listaMsgValidacoes.add(PRESIDIARIO + MENSAGEM + POLICIAL);
				return false;
			}
		}
		if (novoPassageiro instanceof Policial) {
			//Se policial instanciado e lista não estiver com um presidiario, então
			//policial não pode desembarcar no local.
			if (!Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Presidiario.class)) {
				listaMsgValidacoes.add(POLICIAL + MENSAGEM + PRESIDIARIO);
				return false;
			}
		}
		if (novoPassageiro instanceof Oficial || novoPassageiro instanceof Comissario ||
			novoPassageiro instanceof Piloto ||  novoPassageiro instanceof ChefeVoo) {
			
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Presidiario.class) &&
				!Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Policial.class)) {
				listaMsgValidacoes.add(PRESIDIARIO + MENSAGEM + POLICIAL);
				return false;
			}
		}
		return true;
	}

}
