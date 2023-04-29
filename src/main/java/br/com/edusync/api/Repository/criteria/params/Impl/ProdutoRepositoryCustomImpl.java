package br.com.edusync.api.Repository.criteria.params.Impl;

import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.criteria.ProdutoRepositoryCustom;
import br.com.edusync.api.Repository.criteria.params.ProdutoFilteParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {

    private EntityManager entityManager;

    public ProdutoRepositoryCustomImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ProdutoModel> getfiltro(ProdutoFilteParam params) {

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<ProdutoModel> query = criteriaBuilder.createQuery(ProdutoModel.class);

        Root<ProdutoModel> produtoModelRoot = query.from(ProdutoModel.class);
        List<Predicate> predicates = new ArrayList<>();
        if (params.getDescricao() != null){
            predicates.add(criteriaBuilder.like(produtoModelRoot.get("descricao"),"%" + params.getDescricao() + "%"));
        }
        if (params.getSaldoatual() != null) {
            predicates.add(criteriaBuilder.equal(produtoModelRoot.get("datavalidade"),params.getSaldoatual()));
        }
        if (params.getPrecovenda() != null) {
            predicates.add(criteriaBuilder.equal(produtoModelRoot.get("precovenda"),params.getPrecovenda()));
        }

        if (!predicates.isEmpty()) {
            query.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<ProdutoModel> queryresult = this.entityManager.createQuery(query);
        return queryresult.getResultList();
    }

    public List<ProdutoModel>listarpositivos(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); CriteriaQuery<ProdutoModel> cq = cb.createQuery (ProdutoModel.class);

        Root<ProdutoModel> produtoRoot = cq. from (ProdutoModel.class);

        cq.select(produtoRoot). where (cb.gt (produtoRoot.get("SaldoAtual"), 0));

        TypedQuery<ProdutoModel> typedResult = this.entityManager.createQuery(cq);

        return typedResult.getResultList();
    }


}
