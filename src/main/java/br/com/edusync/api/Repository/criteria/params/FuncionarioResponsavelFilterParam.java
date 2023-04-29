package br.com.edusync.api.Repository.criteria.params;


import lombok.Data;

@Data
public class FuncionarioResponsavelFilterParam {

    private String nome;

    private String cpf;

    private String cargo;
}
