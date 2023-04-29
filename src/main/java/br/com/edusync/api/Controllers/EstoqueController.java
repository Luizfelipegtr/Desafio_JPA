package br.com.edusync.api.Controllers;

import br.com.edusync.api.Models.EstoqueModel;
import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Services.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/Estoque")
@RestController
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    @Operation(summary = "adicionar estoque", description = "adiciona um estoque")
    @ApiResponse(responseCode = "201", description = "o estoque foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addestoque(@RequestBody EstoqueModel estoqueModel) {
        estoqueService.adicionar(estoqueModel);
        return new ResponseEntity(estoqueModel, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todos os estoques")
    @ApiResponse(responseCode = "201", description = "Todos os estoques foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(estoqueService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem dos estoques")
    @ApiResponse(responseCode = "201", description = "Todos os estoquesforam listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscsarporid(@RequestParam Integer id){
        return new ResponseEntity<>(estoqueService.buscarporid(id),HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar estoque", description = "altera um estoque pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody EstoqueModel estoqueModel){
        estoqueService.update(id,estoqueModel);
        return new ResponseEntity<>(estoqueModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @Operation(summary = "remover estoque",description = "metodo para remover estoque pelo id.")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity remover(@PathVariable Integer id){
        estoqueService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
