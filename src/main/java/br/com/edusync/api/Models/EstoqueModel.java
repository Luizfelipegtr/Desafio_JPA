package br.com.edusync.api.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity(name = "tb_estoque_movimento")
public class EstoqueModel {

    //formy keys

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estoqueid;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;


    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioResponsavelModel funcionario;


    @Column(name = "data_hora")
    private Timestamp datahora;

    @Column(name = "tipo_movimento")
    private String tipomovimento;

    private Integer quantidade;


}