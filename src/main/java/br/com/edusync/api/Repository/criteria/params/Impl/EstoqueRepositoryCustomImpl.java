package br.com.edusync.api.Repository.criteria.params.Impl;

import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.criteria.EstoqueRepositoryCustom;
import br.com.edusync.api.Repository.criteria.params.EstoqueFilterParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EstoqueRepositoryCustomImpl implements EstoqueRepositoryCustom {
    private EntityManager entityManager;
    public EstoqueRepositoryCustomImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ProdutoModel> listarpositivos(EstoqueFilterParam param) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); CriteriaQuery<ProdutoModel> cq = cb.createQuery (ProdutoModel.class);

        Root<ProdutoModel> produtoRoot = cq. from (ProdutoModel.class);

        cq.select(produtoRoot). where (cb.gt (produtoRoot.get("SaldoAtual"), 0));

        TypedQuery<ProdutoModel> typedResult = this.entityManager.createQuery(cq);

        return typedResult.getResultList();
    }
}
