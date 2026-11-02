package com.strategy.integration;

public class Cliente {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String pagar(Pedido pedido, String tipoPagamento) {
        FormaPagamento formaPagamento = FormaPagamentoFactory.getInstancia().obterFormaPagamento(tipoPagamento);
        return pedido.pagar(formaPagamento);
    }
}
