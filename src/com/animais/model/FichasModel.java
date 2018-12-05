package com.animais.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="ficha")
public class FichasModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fch_codigo")
	Integer codigo;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_dt_cadastro", updatable = false, insertable = true)
	Date dtCadastro = new Date();
	
	@Column(name="fch_observacao", length=150, nullable=false)
	String observacao;
	
	@Column(name="fch_ativo")
	Boolean ativo;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinTable(name="Ficha_Animais", 
				joinColumns = @JoinColumn(name="fch_codigo"),
				inverseJoinColumns = @JoinColumn(name="ani_codigo"))
	private List<AnimaisModel> animaismodel;
	
	

	public FichasModel() {
		
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public Date getDtCadastro() {
		return dtCadastro;
	}



	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	public List<AnimaisModel> getAnimaismodel() {
		return animaismodel;
	}



	public void setAnimaismodel(List<AnimaisModel> animaismodel) {
		this.animaismodel = animaismodel;
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
		FichasModel other = (FichasModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



	public FichasModel(Integer codigo, Date dtCadastro, String observacao, Boolean ativo,
			List<AnimaisModel> animaismodel) {
		this.codigo = codigo;
		this.dtCadastro = dtCadastro;
		this.observacao = observacao;
		this.ativo = ativo;
		this.animaismodel = animaismodel;
	}
}
