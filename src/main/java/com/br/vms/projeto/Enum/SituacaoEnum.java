package com.br.vms.projeto.Enum;

public enum SituacaoEnum {
	
	ATIVO("Ativo"),
	PENDENTE("Pendente"),
	CANCELADO("Cancelado");
	
	
	SituacaoEnum(String situacao) {
		this.descricao = situacao;
	}
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
}
