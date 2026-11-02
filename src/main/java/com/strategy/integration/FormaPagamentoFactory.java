package com.strategy.integration;

public class FormaPagamentoFactory {

    private FormaPagamentoFactory() {};
    private static FormaPagamentoFactory instancia = new FormaPagamentoFactory();

    public static FormaPagamentoFactory getInstancia() {
        return instancia;
    }

    public FormaPagamento obterFormaPagamento(String tipo) {
        Class<?> classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("com.strategy.integration.FormaPagamento" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Forma de pagamento inexistente");
        }
        if (!(objeto instanceof FormaPagamento)) {
            throw new IllegalArgumentException("Forma de pagamento inválida");
        }
        return (FormaPagamento) objeto;
    }
}
