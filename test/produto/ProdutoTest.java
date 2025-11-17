package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdu��o ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdu��o ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);
		
	}

	@Test
	public void testaGetNome() {
		Produto filme = new Produto("Batman", 50.00);
		assertEquals("Batman", filme.getNome());
	}

	@Test
	public void testaSetNome() {
    	Produto filme = new Produto("Batman", 50.00);
    	filme.setNome("Superman");
    	assertEquals("Superman", filme.getNome());
	}

	@Test
	public void testaGetPreco() {
    	Produto filme = new Produto("Batman", 50.00);
    	assertEquals(50.00, filme.getPreco(), 0.01);
	}

	@Test
	public void testaSetPreco() {
    	Produto filme = new Produto("Batman", 50.00);
    	filme.setPreco(75.50);
    	assertEquals(75.50, filme.getPreco(), 0.01);
	}

	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}

}
