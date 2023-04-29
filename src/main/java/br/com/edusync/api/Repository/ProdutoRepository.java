package br.com.edusync.api.Repository;

import br.com.edusync.api.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
}