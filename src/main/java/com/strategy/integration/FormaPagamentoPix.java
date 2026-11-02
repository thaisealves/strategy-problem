package com.strategy.integration;

public class FormaPagamentoPix extends FormaPagamentoAbstrata {

    public String getTipo() {
        return "Pix";
    }

    @Override
    public double calcularDesconto(double valor) {
        return valor * 0.05;
    }
}
