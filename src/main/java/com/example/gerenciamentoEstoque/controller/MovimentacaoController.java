package com.example.gerenciamentoEstoque.controller;

import com.example.gerenciamentoEstoque.model.dto.MovimentacaoDto;
import com.example.gerenciamentoEstoque.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/movimentacao")
public class MovimentacaoController {
    @Autowired //comentario
    MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<MovimentacaoDto> cadastrar(@RequestBody @Valid MovimentacaoDto movimentacao) {
        MovimentacaoDto novaMovimentacao = movimentacaoService.novaMovimentacao(movimentacao);
        return new ResponseEntity<>(novaMovimentacao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoDto>> historicoDeMovimentacoes() {
        return ResponseEntity.ok(movimentacaoService.historicoDeMovimentacoes());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<MovimentacaoDto> exibirPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimentacaoService.exibirMovimentacaoPorId(id));
    }
}
