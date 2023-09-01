package com.example.gerenciamentoEstoque.repository;

import com.example.gerenciamentoEstoque.model.MovimentacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Long> {
}
