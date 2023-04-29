package br.com.edusync.api.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_produto")
public class ProdutoModel {

    @Id
    private Integer produtoid;

    private String descricao;

    private BigDecimal precovenda;

    private Integer saldoatual;

}