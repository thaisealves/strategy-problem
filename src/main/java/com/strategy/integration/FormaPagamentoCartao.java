package com.strategy.integration;

public class FormaPagamentoCartao extends FormaPagamentoAbstrata {

    public String getTipo() {
        return "Cartão";
    }

    @Override
    public double calcularAcrescimo(double valor) {
        return valor * 0.03;
    }
}
