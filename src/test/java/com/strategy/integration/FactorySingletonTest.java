package com.strategy.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorySingletonTest {

    @Test
    void deveRetornarSempreAMesmaFabrica() {
        assertSame(FormaPagamentoFactory.getInstancia(), FormaPagamentoFactory.getInstancia());
    }

    @Test
    void deveCriarFormaPagamentoPeloTipo() {
        FormaPagamentoFactory fabrica = FormaPagamentoFactory.getInstancia();
        assertInstanceOf(FormaPagamentoPix.class, fabrica.obterFormaPagamento("Pix"));
        assertInstanceOf(FormaPagamentoCartao.class, fabrica.obterFormaPagamento("Cartao"));
        assertInstanceOf(FormaPagamentoBoleto.class, fabrica.obterFormaPagamento("Boleto"));
    }

    @Test
    void deveRecusarFormaPagamentoInexistente() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> FormaPagamentoFactory.getInstancia().obterFormaPagamento("Cheque"));
        assertEquals("Forma de pagamento inexistente", e.getMessage());
    }

    @Test
    void deveRecusarClasseQueNaoEhFormaPagamento() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> FormaPagamentoFactory.getInstancia().obterFormaPagamento("NaoImplementa"));
        assertEquals("Forma de pagamento inválida", e.getMessage());
    }

    @Test
    void clienteDevePagarInformandoApenasOTipo() {
        Cliente cliente = new Cliente("Ana");
        Pedido pedido = new Pedido(100.0);
        assertEquals("Pedido pago via Pix", cliente.pagar(pedido, "Pix"));
        assertEquals(95.0, pedido.getValorPago(), 0.001);
    }

    @Test
    void deveAceitarNovaFormaPagamentoSemAlterarCodigoExistente() {
        Cliente cliente = new Cliente("Ana");
        Pedido pedido = new Pedido(100.0);
        assertEquals("Pedido pago via Cripto", cliente.pagar(pedido, "Cripto"));
        assertEquals(101.0, pedido.getValorPago(), 0.001);
    }
}
