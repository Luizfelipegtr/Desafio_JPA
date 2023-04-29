package br.com.edusync.api.Controllers;

import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import br.com.edusync.api.Models.ProdutoModel;
import br.com.edusync.api.Repository.criteria.params.ProdutoFilteParam;
import br.com.edusync.api.Services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequestMapping(value = "/Produto")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Operation(summary = "adicionar produtos", description = "adiciona um produto")
    @ApiResponse(responseCode = "201", description = "o produto foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addprodutos(@RequestBody ProdutoModel produto) {
        produtoService.adicionar(produto);
        return new ResponseEntity(produto, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todos os produtos")
    @ApiResponse(responseCode = "201", description = "Todos os produtos foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(produtoService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem dos produtos ")
    @ApiResponse(responseCode = "201", description = "Todos os produtos foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporid(@RequestParam Integer produtoid){
        return new ResponseEntity<>(produtoService.buscarporid(produtoid),HttpStatus.OK);
    }


    @GetMapping(value="/listarpositivos")
    @Operation(summary = "Listar os produtos positivos", description = "Faz a listagem dos produtos que se encontram com valor positivo")
    @ApiResponse(responseCode = "201", description = "Todos os produtos positivos foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listarPositivo() {
        try {
            return new ResponseEntity<>(produtoService.listarpositivo(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Não foi possivel listar todos os produtoss positivos! Tente novamente.", HttpStatus.BAD_REQUEST);

        }
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar produto", description = "altera um produto pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ProdutoModel produtoModel){
        produtoService.update(id,produtoModel);
        return new ResponseEntity<>(produtoModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ApiResponse(responseCode = "201", description = "Produto removido com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    @Operation(summary = "remover produto",description = "metodo para remover produto pelo id")
    public ResponseEntity remover(@PathVariable Integer id){
        produtoService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping(value = "/filtro")
    @Operation(summary = "filtrar",description = "metodo para filtrar produtos e listar.")
    @ApiResponse(responseCode = "201", description = "Produto removido com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity filtrar(ProdutoFilteParam produtoFilteParam){
        return new ResponseEntity<>(produtoService.filtrar(produtoFilteParam),HttpStatus.OK);
    }

}