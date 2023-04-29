package br.com.edusync.api.Services;

import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.ProdutoRepository;
import br.com.edusync.api.Repository.criteria.ProdutoRepositoryCustom;
import br.com.edusync.api.Repository.criteria.params.Impl.ProdutoRepositoryCustomImpl;
import br.com.edusync.api.Repository.criteria.params.ProdutoFilteParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoRepositoryCustom produtoRepositoryCustom;

    @Autowired
    private ProdutoRepositoryCustomImpl produtoRepositoryCustomImpl;



    public void adicionar(ProdutoModel produtoModel){
        produtoRepository.save(produtoModel);
    }



    public Object listartudo(){
        return produtoRepository.findAll();
    }



    public List<ProdutoModel> listarpositivo() {
        return produtoRepositoryCustomImpl.listarpositivos();
    }



    public ProdutoModel buscarporid(Integer produtoid) {
        Optional<ProdutoModel> optfuncionario = produtoRepository.findById(produtoid);

        if(optfuncionario.isEmpty()){

            throw new NoSuchElementException("funcionario não encontrado!");
        }
        return optfuncionario.get();
    }



    public void update(Integer cpf, ProdutoModel produtoModel) {
        remover(cpf);
        adicionar(produtoModel);
    }



    public void remover(Integer cpf) {
        produtoRepository.deleteById(cpf);
    }



    public List<ProdutoModel> filtrar(ProdutoFilteParam produtoFilteParam){
        return produtoRepositoryCustom.getfiltro(produtoFilteParam);
    }


}
