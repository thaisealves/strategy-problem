package com.strategy.integration;

public class FormaPagamentoBoleto extends FormaPagamentoAbstrata {

    public String getTipo() {
        return "Boleto";
    }

    @Override
    public double getValorMinimo() {
        return 10.0;
    }

    @Override
    public double calcularAcrescimo(double valor) {
        return 2.50;
    }
}
