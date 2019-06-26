package br.edu.scv.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Criado para criar um evento de casamento
 * @author jclri
 *
 */

@Entity
public class CadastroCasamento {
	
	@Id
	@SequenceGenerator(name = "CONTADOR_EVENTO", sequenceName = "NUM_SEQ_EVENTO", allocationSize = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CONTADOR_EVENTO")
	private Integer id;
	
	@NotNull
	private String noivos;
	
	@NotNull
	private String localDoEvento;
	
	@NotNull
	private String localDaCerimonia;

	@NotNull
	private Date data;
	
	@NotNull
	private String telefone;
	
	@NotNull
	@Min (value = 100, message = "O numero minimo de convidades é 100")
	@Max (value = 200, message = "O numero maximo de convidades é 200")
	private Integer numeroDeConvidados;
	
	@NotNull
	private String tipoDeContratacao;
	
	@NotNull
	@DecimalMin (value = "5200", message = "O valor minimo para contrato é de R$5.200,00")
	private Double valorContratado;
	
	@NotNull
	private String valorPago;
	
	
	public CadastroCasamento() {

	}

	public String getNoivos() {
		return noivos;
	}

	public void setNoivos(String noivos) {
		this.noivos = noivos;
	}

	public String getLocalDoEvento() {
		return localDoEvento;
	}

	public void setLocalDoEvento(String localDoEvento) {
		this.localDoEvento = localDoEvento;
	}

	public String getLocalDaCerimonia() {
		return localDaCerimonia;
	}

	public void setLocalDaCerimonia(String localDaCerimonia) {
		this.localDaCerimonia = localDaCerimonia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getNumeroDeConvidados() {
		return numeroDeConvidados;
	}

	public void setNumeroDeConvidados(Integer numeroDeConvidados) {
		this.numeroDeConvidados = numeroDeConvidados;
	}

	public String getTipoDeContratacao() {
		return tipoDeContratacao;
	}

	public void setTipoDeContratacao(String tipoDeContratacao) {
		this.tipoDeContratacao = tipoDeContratacao;
	}

	public Double getValorContratado() {
		return valorContratado;
	}

	public void setValorContratado(Double valorContratado) {
		this.valorContratado = valorContratado;
	}

	public String getValorPago() {
		return valorPago;
	}

	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
