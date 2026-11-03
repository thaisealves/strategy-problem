package com.strategy.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrategyTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido(100.0);
    }

    @Test
    void devePagarComPix() {
        assertEquals("Pedido pago via Pix", pedido.pagar(new FormaPagamentoPix()));
        assertEquals(95.0, pedido.getValorPago(), 0.001);
    }

    @Test
    void devePagarComCartao() {
        assertEquals("Pedido pago via Cartão", pedido.pagar(new FormaPagamentoCartao()));
        assertEquals(103.0, pedido.getValorPago(), 0.001);
    }

    @Test
    void devePagarComBoleto() {
        assertEquals("Pedido pago via Boleto", pedido.pagar(new FormaPagamentoBoleto()));
        assertEquals(102.5, pedido.getValorPago(), 0.001);
    }

    @Test
    void naoDevePagarPedidoJaPago() {
        pedido.pagar(new FormaPagamentoPix());
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> pedido.pagar(new FormaPagamentoCartao()));
        assertEquals("Pedido já foi pago", e.getMessage());
        assertEquals("Pix", pedido.getFormaPagamento().getTipo());
    }
}
