package br.com.edusync.api.Repository;

import br.com.edusync.api.Models.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
}
