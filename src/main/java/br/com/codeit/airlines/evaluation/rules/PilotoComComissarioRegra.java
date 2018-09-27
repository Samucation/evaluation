package br.com.codeit.airlines.evaluation.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Piloto;

@Component
public class PilotoComComissarioRegra implements Regra {
	
	private static final String PILOTO = "Piloto ";
	private static final String COMISSARIO = "Comissario ";
	private static final String MENSAGEM = "não pode ficar sozinho com ";

	@Override
	public boolean verificaSePodeSerTransferido(List<Passageiro> listaDePassageiros, Passageiro novoPassageiro, List<String> listaMsgValidacoes) {
		
		if (novoPassageiro instanceof Piloto) {

			//Se estiver no local algum comissario e não ter mais ninguém da tripuação, então não da permissão.
			//Piloto fica sozinho com a comisária e isso não pode.
			if (Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Comissario.class) &&
			   !Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, ChefeVoo.class) && 
			   !Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Oficial.class)) {
				
				listaMsgValidacoes.add(PILOTO + MENSAGEM + COMISSARIO);
				return false;
			}
			
			//Se estiver no local algum comissario mas exista mais alguém da tripulação, então pode embarcar o piloto.
			//Pois o piloto não vai ficar sozinho com a comissaria uma vez que existe alguém da tripulação.
			if (Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Comissario.class) &&
				Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, ChefeVoo.class) || 
				Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Oficial.class)) {
				
				return true;
			}
		}
		if (novoPassageiro instanceof Comissario) {
			//Se piloto existir no local, e nenhum outro tripulante, então não pode embarcar o comissário.
			//Comissário não pode ficar sozinho com piloto.
			if (Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Piloto.class) && 
			   !Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, ChefeVoo.class) &&
			   !Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Oficial.class)) {
				
				listaMsgValidacoes.add(COMISSARIO + MENSAGEM + PILOTO);
				return false;
			}
			
			//Se piloto existir mas existir no local mas exista algum chefe de voo ou oficial, então o comissário pode embarcar.
			//Pois comissário não vai ficar sozinho com o piloto.
			if (Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Piloto.class) &&
				Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, ChefeVoo.class) ||
				Regra.tipoDePassageiroExisteNoLocal(listaDePassageiros, Oficial.class)) {
				
				return true;
			}
		}
		return true;
	}

}
