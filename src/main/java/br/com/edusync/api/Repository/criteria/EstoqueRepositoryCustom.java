package br.com.edusync.api.Repository.criteria;

import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.criteria.params.EstoqueFilterParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepositoryCustom {
    List<ProdutoModel> listarpositivos(EstoqueFilterParam param);
}
