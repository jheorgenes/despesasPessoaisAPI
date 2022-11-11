package br.com.ddm.dto;

import br.com.ddm.domain.Despesa;

public class DespesaDTO {
	private Integer id;

	private String nome;

	private String formaPagamento;
	
	private String tipoLancamento;

	private Double valor;

	public DespesaDTO() {}

	public DespesaDTO(Despesa obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.formaPagamento = obj.getFormaPagamento();
		this.tipoLancamento = obj.getTipoLancamento();
		this.valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
}
