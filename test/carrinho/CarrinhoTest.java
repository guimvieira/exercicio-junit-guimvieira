package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    Carrinho carrinho;
    Produto p1;
    Produto p2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        p1 = new Produto("Livro", 100.00);
        p2 = new Produto("Jogo", 150.00);
    }

    @Test
    public void testCriarCarrinho() {
        Assertions.assertAll("carrinho",
            () -> assertEquals(0, carrinho.getQtdeItems()),
            () -> assertEquals(0.0, carrinho.getValorTotal(), 0.01)
        );
    }

    @Test
    public void testaAdicionarUmItem() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);

        Assertions.assertAll("carrinho",
            () -> assertEquals(2, carrinho.getQtdeItems()),
            () -> assertEquals(250.00, carrinho.getValorTotal(), 0.01)
        );
    }

    @Test
    public void testaRemoverUmItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.removeItem(p1);

        Assertions.assertAll("carrinho",
            () -> assertEquals(1, carrinho.getQtdeItems()),
            () -> assertEquals(150.00, carrinho.getValorTotal(), 0.01)
        );
    }

    @Test
    public void testaRemoverUmItemInexistente() {
        carrinho.addItem(p1);

        assertThrows(
            ProdutoNaoEncontradoException.class,
            () -> carrinho.removeItem(p2)
        );
    }


    @Test
    public void testaEsvaziarCarrinho() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);

        carrinho.esvazia();

        Assertions.assertAll("carrinho",
            () -> assertEquals(0, carrinho.getQtdeItems()),
            () -> assertEquals(0.0, carrinho.getValorTotal(), 0.01)
        );
    }

}