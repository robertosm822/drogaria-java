package br.com.drogariaexe.domain;

public class Fabricante {
	private Long codigo;
	private String descricao;
	
	
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString(){
		String saida = codigo + " - "+descricao;
		return saida;
	}

}
