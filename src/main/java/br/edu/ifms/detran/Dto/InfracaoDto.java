package br.edu.ifms.detran.Dto;

import java.io.Serializable;

import br.edu.ifms.detran.model.Infracao;

public class InfracaoDto implements Serializable{

	private Integer id;
	private String descricai;
	private int pontos;
	private float valor;
	
	public InfracaoDto() {
		
	}

	public InfracaoDto(Infracao obj) {
		super();
		this.id = obj.getId();
		this.descricai = obj.getDescricao();
		this.pontos = obj.getPontos();
		this.valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricai() {
		return descricai;
	}

	public void setDescricai(String descricai) {
		this.descricai = descricai;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
