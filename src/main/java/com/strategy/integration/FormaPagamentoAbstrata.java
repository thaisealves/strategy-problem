package com.strategy.integration;

public abstract class FormaPagamentoAbstrata implements FormaPagamento {

    public double getValorMinimo() {
        return 0.01;
    }

    public double calcularAcrescimo(double valor) {
        return 0.0;
    }

    public double calcularDesconto(double valor) {
        return 0.0;
    }

    public final double calcularValorFinal(double valor) {
        if (valor < this.getValorMinimo()) {
            throw new IllegalArgumentException(this.getTipo() + " exige valor mínimo de " + this.getValorMinimo());
        }
        return valor + this.calcularAcrescimo(valor) - this.calcularDesconto(valor);
    }
}
