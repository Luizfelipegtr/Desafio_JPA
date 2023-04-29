package br.com.edusync.api.Services;

import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.FuncionarioRepository;
import br.com.edusync.api.Repository.criteria.FuncionarioResponsavelRepositoryCustom;
import br.com.edusync.api.Repository.criteria.params.FuncionarioResponsavelFilterParam;
import br.com.edusync.api.Repository.criteria.params.ProdutoFilteParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class FuncionarioResponsavelService {

    @Autowired
    public FuncionarioRepository funcionarioRepository;

    public FuncionarioResponsavelRepositoryCustom funcionarioResponsavelRepositoryCustom;



    public void adicionar(FuncionarioResponsavelModel FuncionarioModel){
        funcionarioRepository.save(FuncionarioModel);
    }


    public Object listartudo(){
        return funcionarioRepository.findAll();
    }


    public FuncionarioResponsavelModel buscarporcpf(String cpf) {
        Optional<FuncionarioResponsavelModel> optestoque = funcionarioRepository.findById(cpf);

        if(optestoque.isEmpty()){

            throw new NoSuchElementException("funcionario não encontrado!");
        }
        return optestoque.get();
    }



    public void update(String cpf, FuncionarioResponsavelModel FuncionarioModel) {
        remover(cpf);
        adicionar(FuncionarioModel);
    }


    public void remover(String cpf) {
        funcionarioRepository.deleteById(cpf);
    }



}
