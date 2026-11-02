package com.strategy.integration;

public class Pedido {

    private double valor;
    private FormaPagamento formaPagamento;
    private double valorPago;

    public Pedido(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public boolean isPago() {
        return formaPagamento != null;
    }

    public String pagar(FormaPagamento formaPagamento) {
        if (this.isPago()) {
            throw new IllegalStateException("Pedido já foi pago");
        }
        this.valorPago = formaPagamento.calcularValorFinal(this.valor);
        this.formaPagamento = formaPagamento;
        return "Pedido pago via " + formaPagamento.getTipo();
    }
}
