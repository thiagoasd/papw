package com.rodrigofujioka.dev.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.service.ProdutoService;
import com.rodrigofujioka.dev.web.service.dto.ProdutoNomeMarcaDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;

	// CREATE
	@PostMapping("/produto")
	public ResponseEntity<ProdutoNomeMarcaDTO> salvar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(produtoService.salvar(produto));
	}

	// READ
	@GetMapping("/produto/{id}")
	public ResponseEntity<ProdutoNomeMarcaDTO> getProduto(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorId(id));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com ID " + id);
			return ResponseEntity.notFound().build();
		}
	}

	// UPDATE
	@PostMapping("/produto/{id}")
	public ProdutoNomeMarcaDTO update(Produto produto) {
		if (produto == null) {
			return null;
		} else {
			return produtoService.salvar(produto);
		}
	}

	// DELETE
	@DeleteMapping("/produto/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		try {
			produtoService.deletePorId(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	// READALL
	@GetMapping("/produto")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getAllProduto() {
		return ResponseEntity.ok(produtoService.listar());
	}

	// READ
	@GetMapping("/produto/nome/{nome}")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getProdutoNome(@PathVariable String nome) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorNome(nome));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com nome " + nome);
			return ResponseEntity.notFound().build();
		}
	}

	// READ
	@GetMapping("/produto/marca/{marca}")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getProdutoMarca(@PathVariable String marca) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorMarca(marca));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com marca " + marca);
			return ResponseEntity.notFound().build();
		}
	}

	// READ
	@GetMapping("/produto/codigo/{cod}")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getProdutoCodigo(@PathVariable String cod) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorCodigoBarras(cod));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com codigo de barras " + cod);
			return ResponseEntity.notFound().build();
		}
	}

	// READ
	@GetMapping("/produto/anofabricacao/{ano}")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getProdutoAnoFabricacao(@PathVariable int ano) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorAnoFabricacao(ano));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com ano de fabricacao " + ano);
			return ResponseEntity.notFound().build();
		}
	}

	// READ
	@GetMapping("/produto/nome/marca/{nome}/{marca}")
	public ResponseEntity<List<ProdutoNomeMarcaDTO>> getProdutoNomeMarca(@PathVariable String nome,@PathVariable String marca) {
		try {
			return ResponseEntity.ok(produtoService.consultaPorNomeEMarca(nome, marca));
		} catch (NotFoundException e) {
			System.out.println(e.getMessage() + "com nome " + nome + "e marca " + marca);
			return ResponseEntity.notFound().build();
		}
	}

}