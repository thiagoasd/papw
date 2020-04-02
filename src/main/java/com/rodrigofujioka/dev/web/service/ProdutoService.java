package com.rodrigofujioka.dev.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.repository.ProdutoRepository;
import com.rodrigofujioka.dev.web.service.dto.ProdutoNomeMarcaDTO;

import javassist.NotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// CREATE
	public ProdutoNomeMarcaDTO salvar(Produto produto) {
		return getDTO(produtoRepository.save(produto));
	}

	// READ
	public ProdutoNomeMarcaDTO consultaPorId(long id) throws NotFoundException {

		Optional<Produto> produtoOpt = produtoRepository.findById(id);
		if (produtoOpt.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		return getDTO(produtoOpt.get());
	}

	// UPDATE
	public ProdutoNomeMarcaDTO update(Produto produto) {
		if (produto == null) {
			return null;
		} else {
			return getDTO(produtoRepository.save(produto));
		}
	}

	// DELETE
	public void deletePorId(Long id) {
		produtoRepository.deleteById(id);
	}

	// READALL
	public List<ProdutoNomeMarcaDTO> listar() {

		List<Produto> tmp = produtoRepository.findAll();
		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();

		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;
	}

	// READ BY NAME
	public List<ProdutoNomeMarcaDTO> consultaPorNome(String nome) throws NotFoundException {
		List<Produto> tmp = produtoRepository.findProdutoByNome(nome);

		if (tmp.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();
		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;

	}

	// READ BY MARCA
	public List<ProdutoNomeMarcaDTO> consultaPorMarca(String marca) throws NotFoundException {
		List<Produto> tmp = produtoRepository.findProdutoByMarca(marca);
		if (tmp.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();
		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;

	}
	
	// READ BY CODIGO BARRAS
	public List<ProdutoNomeMarcaDTO> consultaPorCodigoBarras(String codigo) throws NotFoundException {
		List<Produto> tmp = produtoRepository.findProdutoByCodigoBarras(codigo);
		if (tmp.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();
		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;

	}
	
	// READ BY ANO FABRICACAO
	public List<ProdutoNomeMarcaDTO> consultaPorAnoFabricacao(int ano) throws NotFoundException {
		List<Produto> tmp = produtoRepository.findProdutoByAnoFabricacao(ano);
		if (tmp.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();
		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;

	}
	
		public List<ProdutoNomeMarcaDTO> consultaPorNomeEMarca(String Nome, String Marca) throws NotFoundException {
		List<Produto> tmp = produtoRepository.findProdutoByNomeAndMarca(Nome, Marca);
		if (tmp.isEmpty()) {
			throw new NotFoundException("Produto não localizado");
		}

		List<ProdutoNomeMarcaDTO> res = new ArrayList<ProdutoNomeMarcaDTO>();
		for (Produto produto : tmp) {
			res.add(getDTO(produto));
		}

		return res;

	}

	
	
	
	
	
	
	
	
	
	
	
	private ProdutoNomeMarcaDTO getDTO(Produto produto) {
		return new ProdutoNomeMarcaDTO(produto);
	}

}
