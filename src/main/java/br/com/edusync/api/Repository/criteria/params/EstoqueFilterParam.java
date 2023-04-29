package br.com.edusync.api.Repository.criteria.params;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class EstoqueFilterParam {
    private Timestamp datahora;
    private String tipomovimento;
    private Integer quantidade;
}
