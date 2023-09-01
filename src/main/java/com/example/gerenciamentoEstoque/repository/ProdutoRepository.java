package com.example.gerenciamentoEstoque.repository;

import com.example.gerenciamentoEstoque.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    @Query("SELECT p FROM tb_produtos p WHERE p.nome = :nome")
    Optional<ProdutoModel> findByName (@Param("nome") String nome);
}
