package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorOrcamento;
    private BigDecimal descontoOrcamento;

    public Orcamento(){}

    public Orcamento(BigDecimal valorOrcamento, BigDecimal descontoOrcamento) {
        this.valorOrcamento = valorOrcamento;
        this.descontoOrcamento = descontoOrcamento;
    }

    public BigDecimal getDescontoOrcamento() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return descontoOrcamento;
    }

    public void setDescontoOrcamento(BigDecimal descontoOrcamento) {
        this.descontoOrcamento = descontoOrcamento;
    }

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(BigDecimal valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public BigDecimal calcularValorTotal() {
        if (valorOrcamento != null && descontoOrcamento != null) {
            return valorOrcamento.subtract(descontoOrcamento);
        } else {
            throw new IllegalStateException("Valores de orçamento ou desconto não podem ser nulos");
        }
    }

    public Long getId() {
        return id;
    }
}
