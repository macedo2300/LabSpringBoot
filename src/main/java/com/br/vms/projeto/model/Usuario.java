package com.br.vms.projeto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.br.vms.projeto.Enum.SituacaoEnum;

@Entity
@SequenceGenerator(name="SEQ_USUARIO",sequenceName="SEQ_USUARIO",allocationSize=1,initialValue=1)
@Table(name="REQ_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@Column(name ="SEQ_USUARIO")
	private Long codigo;
	
	
	@NotEmpty(message="Campo Nome não pode ser Vazio.")
	@Column(name ="Nome")
	private String nome;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name ="DATANASCIMENTO")
	private Date dataNascimento;
	
	@NotEmpty(message="Campo Endereço não pode ser Vazio.")
	@Column(name ="Endereco")
	private String endereco;
	
	@Column(name ="Bairro")
	private String bairro;
	
	@NotEmpty(message="Campo Cidade não pode ser Vazio.")
	@Column(name ="Cidade")
	private String cidade;
	
	@Column(name ="Estado")
	private String estado;
	
	@Column(name ="Cep")
	private String cep;
	
	@NotNull(message="Campo Valor não pode ser Vazio.")
	@NumberFormat(pattern ="#.##0,00")
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;
	
	public boolean isPendente() {
		return SituacaoEnum.PENDENTE.equals(this.situacao);
	}
	
	public String getLabelSituacao() {
		String label= null;
		if(SituacaoEnum.PENDENTE.equals(this.situacao)) {
			label = "label-warning";
		}else if(SituacaoEnum.CANCELADO.equals(this.situacao)) {
			label = "label-danger";
		}else{
			label = "label-success";
		}
			
		
		
		return label;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
