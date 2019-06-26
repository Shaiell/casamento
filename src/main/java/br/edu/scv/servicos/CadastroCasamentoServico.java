package br.edu.scv.servicos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.scv.entidades.CadastroCasamento;

@Stateless
public class CadastroCasamentoServico {
	
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrarCasamento(CadastroCasamento casamento) throws Exception {
		
		if(casamento.getNumeroDeConvidados() >= 100 && casamento.getNumeroDeConvidados() <= 200) {
			if(casamento.getValorContratado() >= 5200) {
				this.em.persist(casamento);
			} else {
				throw new Exception("Não é permitido contratos com valor inferior a R$5.200,00");
			}
		}else {
			throw new Exception ("O numero de convidades deve ser maior que 99 e inferior a 201");
		}
		
		
	}

	public List<CadastroCasamento> listarCasamentos(){
		Query query = this.em.createQuery("SELECT c FROM CadastroCasamento c ", CadastroCasamento.class );
		
		return query.getResultList();
	}
	
	public void excluirCasamento(CadastroCasamento casamento) throws Exception {
		
		if(casamento.getValorPago().contains("Não")) {
			this.em.remove(this.em.merge(casamento));
		}else {
			throw new Exception("Não é possivel escluir o Evento pois o casamento ja foi pago.");
		}
		
		
		
	}
}
