package br.com.codeit.airlines.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.codeit.airlines.evaluation.exceptions.ValidacaoExcetion;
import br.com.codeit.airlines.evaluation.models.PassageirosRequisicaoRest;
import br.com.codeit.airlines.evaluation.utils.EmbarqueUtils;

@RestController
@RequestMapping("embarcar")
public class ProcessosController {
	
	@Autowired EmbarqueUtils embarqueUtils;
	
	@RequestMapping(value = "plataforma", method = RequestMethod.POST)
	public void embarcarPlataforma(@RequestBody PassageirosRequisicaoRest passageiroMaisLista) throws ValidacaoExcetion {
		embarqueUtils.verificaAutorizacaoEmbarquePlataforma(passageiroMaisLista.listaPassageiros, passageiroMaisLista.passageiro);
	}
	
	@RequestMapping(value = "veiculo", method = RequestMethod.POST)
	public void embarcarVeiculo(@RequestBody PassageirosRequisicaoRest passageiroMaisLista) throws ValidacaoExcetion {
		embarqueUtils.verificaAutorizacaoEmbarqueVeiculoForTwo(passageiroMaisLista.listaPassageiros, passageiroMaisLista.passageiro);
	}
	
}
