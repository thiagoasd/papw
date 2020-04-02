package com.rodrigofujioka.dev.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findProdutoByMarca(String marca);

	List<Produto> findProdutoByNome(String nome);

	List<Produto> findProdutoByCodigoBarras(String codigoBarras);

	List<Produto> findProdutoByAnoFabricacao(int ano);

	List<Produto> findProdutoByNomeAndMarca(String nome, String marca);

}
