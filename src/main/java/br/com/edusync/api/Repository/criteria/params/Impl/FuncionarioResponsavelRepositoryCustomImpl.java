package br.com.edusync.api.Repository.criteria.params.Impl;

import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import br.com.edusync.api.Repository.criteria.FuncionarioResponsavelRepositoryCustom;
import br.com.edusync.api.Repository.criteria.params.FuncionarioResponsavelFilterParam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioResponsavelRepositoryCustomImpl implements FuncionarioResponsavelRepositoryCustom {

    private EntityManager entityManager;

    public FuncionarioResponsavelRepositoryCustomImpl(EntityManager entityManager){
            this.entityManager = entityManager;
    }
}
