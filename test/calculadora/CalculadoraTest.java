package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testeSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(10, 3);
		Assertions.assertEquals(7, subtracao);
	}

	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testeMultiplicaDoisNumeros() {
		int multiplicacao = calc.multiplicacao(5, 3);
		Assertions.assertEquals(15, multiplicacao);
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Testa o somatório de um número")
	@Test
	public void testeSomatorio() {
		int somatorio = calc.somatoria(5);
		assertEquals(15, somatorio);
	}

	@DisplayName("Testa se o número é positivo")
	@Test
	public void testeEhPositivo() {
		boolean ehPositivo = calc.ehPositivo(3);
		assertEquals(True, ehPositivo);
	}

}
