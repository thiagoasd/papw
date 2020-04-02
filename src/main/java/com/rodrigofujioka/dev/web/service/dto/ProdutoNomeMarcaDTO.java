package com.rodrigofujioka.dev.web.service.dto;

import com.rodrigofujioka.dev.web.domain.Produto;

public class ProdutoNomeMarcaDTO {

	String nome;
	String marca;

	public ProdutoNomeMarcaDTO(String nome, String marca) {
		super();
		this.nome = nome;
		this.marca = marca;
	}

	public ProdutoNomeMarcaDTO(Produto produto) {
		this.nome = produto.getNome();
		this.marca = produto.getMarca();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
