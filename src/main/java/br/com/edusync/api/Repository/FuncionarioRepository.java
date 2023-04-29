package br.com.edusync.api.Repository;

import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioResponsavelModel, String> {
}
