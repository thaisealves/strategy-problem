package com.strategy.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemplateMethodTest {

    @Test
    void deveRecusarValorZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new FormaPagamentoPix().calcularValorFinal(0.0));
        assertEquals("Pix exige valor mínimo de 0.01", e.getMessage());
    }

    @Test
    void deveRecusarBoletoAbaixoDoMinimo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new FormaPagamentoBoleto().calcularValorFinal(9.99));
        assertEquals("Boleto exige valor mínimo de 10.0", e.getMessage());
    }

    @Test
    void deveAceitarBoletoNoValorMinimo() {
        assertEquals(12.5, new FormaPagamentoBoleto().calcularValorFinal(10.0), 0.001);
    }

    @Test
    void naoDeveAlterarPedidoQuandoPagamentoRecusado() {
        Pedido pedido = new Pedido(5.0);
        assertThrows(IllegalArgumentException.class, () -> pedido.pagar(new FormaPagamentoBoleto()));
        assertFalse(pedido.isPago());
    }
}
