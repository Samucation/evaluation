package br.com.codeit.airlines.evaluation.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PassageirosRequisicaoRest implements Serializable {

	private static final long serialVersionUID = 2397749417550278670L;
	public Passageiro passageiro;
	public List<Passageiro> listaPassageiros;
	
	
	public PassageirosRequisicaoRest() {
		newObjects();
	}
	
	public PassageirosRequisicaoRest(Passageiro novoPassageiro, List<Passageiro> listaPassageiros) {
		super();
		newObjects();
		this.passageiro = novoPassageiro;
		this.listaPassageiros = listaPassageiros;
	}
	
	private void newObjects() {
		listaPassageiros = new ArrayList<>();
	}
	
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	public List<Passageiro> getListaPassageiros() {
		return listaPassageiros;
	}
	
	public void setListaPassageiros(List<Passageiro> listaPassageiros) {
		this.listaPassageiros = listaPassageiros;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaPassageiros == null) ? 0 : listaPassageiros.hashCode());
		result = prime * result + ((passageiro == null) ? 0 : passageiro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassageirosRequisicaoRest other = (PassageirosRequisicaoRest) obj;
		if (listaPassageiros == null) {
			if (other.listaPassageiros != null)
				return false;
		} else if (!listaPassageiros.equals(other.listaPassageiros))
			return false;
		if (passageiro == null) {
			if (other.passageiro != null)
				return false;
		} else if (!passageiro.equals(other.passageiro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaEmbarqueMaisNovoPassageiro [novoPassageiro=" + passageiro + ", listaPassageiros=" + listaPassageiros
				+ "]";
	}
	
}
