package com.strategy.integration;

// Forma de pagamento nova criada só para teste de integração, não é utilizada no sistema
public class FormaPagamentoCripto extends FormaPagamentoAbstrata {

    public String getTipo() {
        return "Cripto";
    }

    @Override
    public double calcularAcrescimo(double valor) {
        return valor * 0.01;
    }
}
