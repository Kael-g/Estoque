package com.example.gerenciamentoEstoque.service;

import com.example.gerenciamentoEstoque.exception.ProductAlreadyExistsException;
import com.example.gerenciamentoEstoque.exception.ProductNotFoundException;
import com.example.gerenciamentoEstoque.model.ProdutoModel;
import com.example.gerenciamentoEstoque.model.dto.ProdutoAlterarDto;
import com.example.gerenciamentoEstoque.model.dto.ProdutoDto;
import com.example.gerenciamentoEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    private ProdutoModel dtoParaModel (ProdutoDto produtoDto){
        return new ProdutoModel(produtoDto.getNome(), produtoDto.getCategoria(), produtoDto.getDescricao(), produtoDto.getValor(), produtoDto.getQuantidade());
    }

    private ProdutoModel dtoParaModelComId (ProdutoDto produtoDto){
        return new ProdutoModel(produtoDto.getId() ,produtoDto.getNome(), produtoDto.getCategoria(), produtoDto.getDescricao(), produtoDto.getValor(), produtoDto.getQuantidade());
    }

    public ProdutoDto cadastrar(ProdutoDto produtoDto){
        if (!nomeJaCadastrado(produtoDto.getNome())){
            ProdutoModel novoProduto = produtoRepository.save(dtoParaModel(produtoDto));
            return new ProdutoDto(novoProduto);
        } else {
            throw new ProductAlreadyExistsException(exibirProdutoPorNome(produtoDto.getNome()).getNome(), exibirProdutoPorNome(produtoDto.getNome()).getId());
        }
    }

    private boolean nomeJaCadastrado(String nome){
        return produtoRepository.findByName(nome).isPresent();
    }

    public ProdutoDto exibirProdutoPorNome(String nome){
        return new ProdutoDto(produtoRepository.findByName(nome).orElseThrow(() -> new ProductNotFoundException(nome)));
    }

    public List<ProdutoDto> exibirTodos(){
        List<ProdutoDto> produtosDto = new ArrayList<>();
        for (ProdutoModel p : produtoRepository.findAll()){
            produtosDto.add(new ProdutoDto(p));
        }
        return produtosDto;
    }

    public ProdutoDto exibirProdutoPorId(Long id) {
        return new ProdutoDto(produtoRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id)));
    }

    public ProdutoDto alterarProduto(Long id, ProdutoAlterarDto produtoAlterar) {
        ProdutoModel produtoAntigo = dtoParaModelComId(exibirProdutoPorId(id));
        if (produtoAlterar.getNome() != null && produtoAlterar.getNome().length()>0){
            produtoAntigo.setNome(produtoAlterar.getNome());
        }

        if (produtoAlterar.getCategoria() != null && produtoAlterar.getCategoria().length()>0){
            produtoAntigo.setCategoria(produtoAlterar.getCategoria());
        }

        if (produtoAlterar.getDescricao() != null && produtoAlterar.getDescricao().length()>0){
            produtoAntigo.setDescricao(produtoAlterar.getDescricao());
        }

        if (produtoAlterar.getValor() != null){
            produtoAntigo.setValor(produtoAlterar.getValor());
        }

        if (produtoAlterar.getQuantidade() != null){
            produtoAntigo.setQuantidade(produtoAlterar.getQuantidade());
        }

        return new ProdutoDto(produtoRepository.save(produtoAntigo));
    }

    public void deletarPorId(Long id){
        exibirProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}
