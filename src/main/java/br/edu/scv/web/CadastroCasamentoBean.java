package br.edu.scv.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.edu.scv.entidades.CadastroCasamento;
import br.edu.scv.servicos.CadastroCasamentoServico;

@Named
@RequestScoped
public class CadastroCasamentoBean {

	@EJB
	private CadastroCasamentoServico ccs;
	
	private CadastroCasamento casamento;
	
	
	public CadastroCasamentoBean() {
		this.casamento = new CadastroCasamento();
	}
	
	
	public void cadastrarCasamento() {
		
		try {
		this.ccs.cadastrarCasamento(casamento);
		JSFUtils.enviarMensagemDeInformacao("Evento Cadastrado!");
		this.casamento = new CadastroCasamento();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	
	public void excluirCasamento(CadastroCasamento casamento) {
		
		try {
		this.ccs.excluirCasamento(casamento);
		JSFUtils.enviarMensagemDeInformacao("Evento Excluido");
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeInformacao(e.getMessage());
		}
	}
	
	public List<CadastroCasamento> listarCasamento(){
		return this.ccs.listarCasamentos();
	}

	public CadastroCasamentoServico getCcs() {
		return ccs;
	}

	public void setCcs(CadastroCasamentoServico ccs) {
		this.ccs = ccs;
	}

	public CadastroCasamento getCasamento() {
		return casamento;
	}

	public void setCasamento(CadastroCasamento casamento) {
		this.casamento = casamento;
	}
	
}
