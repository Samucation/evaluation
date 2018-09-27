package br.com.codeit.airlines.evaluation.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.codeit.airlines.evaluation.models.ChefeVoo;
import br.com.codeit.airlines.evaluation.models.Comissario;
import br.com.codeit.airlines.evaluation.models.Oficial;
import br.com.codeit.airlines.evaluation.models.Passageiro;
import br.com.codeit.airlines.evaluation.models.Piloto;

@Component
public class ChefeComOficialRegra implements Regra {
	
	
	private static final String CHEFE_VOO = "Chefe de voo ";
	private static final String OFICIAL = "Oficial ";
	private static final String MENSAGEM = "não pode ficar sozinho com ";

	@Override
	public boolean verificaSePodeSerTransferido(List<Passageiro> listaPassageiros, Passageiro novoPassageiro, List<String> listaMsgValidacoes) {
		
		if (novoPassageiro instanceof ChefeVoo) {
			//Se estiver no local algum oficial e não ter mais ninguém da tripuação, então não da permissão.
			//Chefe de voo, pois ele irá ficar sozinho com um oficial, e isso não pode.
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Oficial.class) &&
			   !Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Piloto.class) && 
			   !Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Comissario.class)) {
				
				listaMsgValidacoes.add(CHEFE_VOO + MENSAGEM + OFICIAL);
				return false;
			}
			
			//Se estiver no local algum oficial mas exista mais alguém da tripulação, então pode embarcar o chefe de voo.
			//Pois o chefe de voo não vai ficar sozinho com a oficial, uma vez que existe alguém da tripulação.
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Oficial.class) &&
				Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Piloto.class) || 
				Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Comissario.class)) {
				
				return true;
			}
		}
		if (novoPassageiro instanceof Oficial) {
			//Se chefe de voo existir no local, e nenhum outro tripulante, então não pode embarcar o oficial.
			//chefe de voo não pode ficar sozinho com oficial.
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, ChefeVoo.class) && 
			   !Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Piloto.class) &&
			   !Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Oficial.class)) {
				
				listaMsgValidacoes.add(OFICIAL + MENSAGEM + CHEFE_VOO);
				return false;
			}
			
			//Se chefe de voo existir mas exista algum piloto ou comisário, então o oficial pode embarcar.
			//Pois oficial não vai ficar sozinho com o chefe de voo.
			if (Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, ChefeVoo.class) &&
				Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Piloto.class) ||
				Regra.tipoDePassageiroExisteNoLocal(listaPassageiros, Comissario.class)) {
				
				return true;
			}
		}
		return true;
	}
}
