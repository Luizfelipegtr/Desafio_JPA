package br.com.edusync.api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_funcionario_responsavel")
public class FuncionarioResponsavelModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionarioid;

    private String nome;

    private String cpf;

    private String cargo;

}