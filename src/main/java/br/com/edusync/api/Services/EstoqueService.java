package br.com.edusync.api.Services;

import br.com.edusync.api.Models.EstoqueModel;
import br.com.edusync.api.Repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    public EstoqueRepository estoqueRepository;



    public void adicionar(EstoqueModel estoqueModel){
        estoqueRepository.save(estoqueModel);
    }





    public Object listartudo(){
        return estoqueRepository.findAll();
    }





    public EstoqueModel buscarporid(Integer id) {
        Optional<EstoqueModel> optestoque = estoqueRepository.findById(id);

        if(optestoque.isEmpty()){

            throw new NoSuchElementException("funcionario não encontrado!");
        }
        return optestoque.get();
    }





    public void update(Integer estoqueid, EstoqueModel estoqueModel) {
        remover(estoqueid);
        adicionar(estoqueModel);
    }





    public void remover(Integer estoqueid) {
        estoqueRepository.deleteById(estoqueid);
    }
}
