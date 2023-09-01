package com.example.gerenciamentoEstoque.controller;

import com.example.gerenciamentoEstoque.model.dto.ProdutoAlterarDto;
import com.example.gerenciamentoEstoque.model.dto.ProdutoDto;
import com.example.gerenciamentoEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtosService;

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoDto produto){
        ProdutoDto novoProduto = produtosService.cadastrar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> exibirTodos(){
        return ResponseEntity.ok(produtosService.exibirTodos());
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<ProdutoDto> exibirPorNome (@PathVariable String nome){
        return ResponseEntity.ok(produtosService.exibirProdutoPorNome(nome));
    }
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<ProdutoDto> exibirPorId (@PathVariable Long id){
        return ResponseEntity.ok(produtosService.exibirProdutoPorId(id));
    }

    @PutMapping(path = "/{id}")
    public ProdutoDto alterarProduto(@RequestBody @Valid ProdutoAlterarDto produtoAlterar, @PathVariable Long id){
        return produtosService.alterarProduto(id, produtoAlterar);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarProdutoPorId(@PathVariable Long id){
        produtosService.deletarPorId(id);
    }
}
