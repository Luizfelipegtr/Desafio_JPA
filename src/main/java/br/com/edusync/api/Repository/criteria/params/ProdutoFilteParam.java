package br.com.edusync.api.Repository.criteria.params;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

@Data
public class ProdutoFilteParam {
    private String descricao;
    private BigDecimal precovenda;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Integer saldoatual;
}
