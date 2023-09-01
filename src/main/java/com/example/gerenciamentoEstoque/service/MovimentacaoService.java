package com.example.gerenciamentoEstoque.service;

import com.example.gerenciamentoEstoque.exception.ManagementNotFoundException;
import com.example.gerenciamentoEstoque.exception.ProductNotFoundException;
import com.example.gerenciamentoEstoque.model.MovimentacaoModel;
import com.example.gerenciamentoEstoque.model.ProdutoModel;
import com.example.gerenciamentoEstoque.model.dto.MovimentacaoDto;
import com.example.gerenciamentoEstoque.model.factory.MovimentacaoFactory;
import com.example.gerenciamentoEstoque.repository.MovimentacaoRepository;
import com.example.gerenciamentoEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    MovimentacaoRepository movimentacaoRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    public MovimentacaoDto novaMovimentacao(MovimentacaoDto movimentacaoDto){
        MovimentacaoModel movimentacaoModel = new MovimentacaoModel(movimentacaoDto.getProduto(), movimentacaoDto.getQuantidadeMovimentada(), 0, movimentacaoDto.getTipo(), "Não realizada");

        try {
            ProdutoModel produtoModel = retornarProdutoCompleto(movimentacaoDto.getProduto().getId());

            movimentacaoModel.setProduto(produtoModel);

            movimentacaoModel.setQuantidadeFinal(movimentacaoModel.getProduto().getQuantidade());

            Integer quantidadeFinal = (new MovimentacaoFactory()
                    .tipoMovimentacao(movimentacaoModel.getTipo())
                    .calculo(movimentacaoModel.getProduto().getQuantidade(), movimentacaoModel.getQuantidadeMovimentada()));

            movimentacaoModel.setQuantidadeFinal(quantidadeFinal);

            movimentacaoModel.getProduto().setQuantidade(quantidadeFinal);

            produtoRepository.save(movimentacaoModel.getProduto());

            movimentacaoModel.setStatus("Realizada");

            return new MovimentacaoDto(movimentacaoRepository.save(movimentacaoModel));
        } finally {
            new MovimentacaoDto(movimentacaoRepository.save(movimentacaoModel));
        }
    }

    private ProdutoModel retornarProdutoCompleto(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<MovimentacaoDto> historicoDeMovimentacoes(){
        List<MovimentacaoDto> movimentacoesDto = new ArrayList<>();
        for (MovimentacaoModel m : movimentacaoRepository.findAll()){
            movimentacoesDto.add(new MovimentacaoDto(m));
        }
        return movimentacoesDto;
    }

    public MovimentacaoDto exibirMovimentacaoPorId(Long id) {
        return new MovimentacaoDto(movimentacaoRepository.findById(id).orElseThrow(() -> new ManagementNotFoundException(id)));
    }

}
