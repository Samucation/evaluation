package br.com.codeit.airlines.evaluation.rules;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.codeit.airlines.evaluation.annotations.Motorista;
import br.com.codeit.airlines.evaluation.models.Passageiro;

@Component
public class VeiculoFotTwoRegra implements Regra {

	@Override
	public boolean verificaSePodeSerTransferido(List<Passageiro> listaPassageiros, Passageiro novoPassageiro,
			                                    List<String> listaMsgValidacoes) {
		
		assert listaPassageiros != null && novoPassageiro != null && listaMsgValidacoes != null : "Parametros nao podem ser nulos";
		long quantidadeMotoristas = listaPassageiros.stream().filter(p -> p.getClass().isAnnotationPresent(Motorista.class)).count();
		long quantidadeDePassageirosForTwo = listaPassageiros.size() + (Objects.nonNull(novoPassageiro) ? 1 : 0);
		
		if (quantidadeMotoristas == 0 && !novoPassageiro.getClass().isAnnotationPresent(Motorista.class)) {
			listaMsgValidacoes.add("Deve existir pelo menos um motorista");
		}
		if(quantidadeDePassageirosForTwo < 1 || quantidadeDePassageirosForTwo > 2) {
			listaMsgValidacoes.add("Excede a quantidade de tripulantes permitida pelo ForTwo Veiculo");
		}
		return true;
	}

	public static Regra getInstance() {
		return new VeiculoFotTwoRegra();
	}
}
