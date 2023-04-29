package br.com.edusync.api.Controllers;

import br.com.edusync.api.Models.FuncionarioResponsavelModel;
import br.com.edusync.api.Repository.criteria.params.FuncionarioResponsavelFilterParam;
import br.com.edusync.api.Services.FuncionarioResponsavelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Funcionario-responsavel")
public class FuncionarioResponsavelController {
    @Autowired
    private FuncionarioResponsavelService funcionarioResponsavelService;



    @PostMapping
    @Operation(summary = "adicionar funcionario responsavel", description = "adiciona um funcionario Responsavel")
    @ApiResponse(responseCode = "201", description = "o funcionario foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addfuncionario(@RequestBody FuncionarioResponsavelModel funcionarioResponsavelModel) {
        funcionarioResponsavelService.adicionar(funcionarioResponsavelModel);
        return new ResponseEntity(funcionarioResponsavelModel, HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todos os funcionarios responsaveis")
    @ApiResponse(responseCode = "201", description = "Todos os funcionarios foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente navemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(funcionarioResponsavelService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{cpf}")
    @Operation(summary = "Buscar por cpf", description = "busca funcionarios pelo cpf")
    @ApiResponse(responseCode = "201", description = "o funcionario foi achado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporcpf(@RequestParam String cpf){
        return new ResponseEntity<>(funcionarioResponsavelService.buscarporcpf(cpf),HttpStatus.OK);
    }


    @PutMapping(value = "/{cpf}")
    @Operation(summary = "Listar os produtos positivos", description = "Faz a listagem dos produtos que se encontram com valor positivo")
    @ApiResponse(responseCode = "201", description = "Todos os produtos positivos foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable String cpf, @RequestBody FuncionarioResponsavelModel funcionarioResponsavelModel){
        funcionarioResponsavelService.update(cpf,funcionarioResponsavelModel);
        return new ResponseEntity<>(funcionarioResponsavelModel,HttpStatus.OK);
    }




    @DeleteMapping(value = "/{cpf}")
    @Operation(summary = "remover funcionario",description = "metodo para remover funcionarios pelo cpf.")
    @ApiResponse(responseCode = "201", description = "funcionario removido com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente nevemente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity remover(@PathVariable String cpf){
        funcionarioResponsavelService.remover(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
