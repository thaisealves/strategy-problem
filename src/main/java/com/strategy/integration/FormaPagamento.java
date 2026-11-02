package com.strategy.integration;

public interface FormaPagamento {

    String getTipo();

    double calcularValorFinal(double valor);
}
