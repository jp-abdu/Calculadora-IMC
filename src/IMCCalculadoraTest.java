import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para IMCCalculadora.
 * Utiliza JUnit 5 para validar o cálculo e classificação do IMC.
 * Inclui testes de valor-limite e casos de exceção.
 */
public class IMCCalculadoraTest {

    /**
     * Teste de valor-limite: IMC exatamente 18.5 (limite inferior do peso normal)
     */
    @Test
    void testValorLimiteInferiorPesoNormal() {
        double imc = 18.5;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc));
    }

    /**
     * Teste de valor-limite: IMC exatamente 25 (limite inferior do sobrepeso)
     */
    @Test
    void testValorLimiteInferiorSobrepeso() {
        double imc = 25.0;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc));
    }

    /**
     * Teste de valor-limite: IMC exatamente 30 (limite inferior da obesidade grau I)
     */
    @Test
    void testValorLimiteInferiorObesidadeI() {
        double imc = 30.0;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc));
    }

    /**
     * Teste de valor-limite: IMC exatamente 35 (limite inferior da obesidade grau II)
     */
    @Test
    void testValorLimiteInferiorObesidadeII() {
        double imc = 35.0;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc));
    }

    /**
     * Teste de valor-limite: IMC exatamente 40 (limite inferior da obesidade grau III)
     */
    @Test
    void testValorLimiteInferiorObesidadeIII() {
        double imc = 40.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc));
    }

    /**
     * Teste de cálculo do IMC com valores típicos.
     */
    @Test
    void testCalculoIMC() {
        double peso = 70.0;
        double altura = 1.75;
        double imc = IMCCalculadora.calcularIMC(peso, altura);
        assertEquals(22.8571, imc, 0.0001); // Valor esperado arredondado
    }

    /**
     * Teste de exceção: peso zero.
     */
    @Test
    void testPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(0, 1.70));
    }

    /**
     * Teste de exceção: altura zero.
     */
    @Test
    void testAlturaZero() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(70, 0));
    }

    /**
     * Teste de exceção: valores negativos.
     */
    @Test
    void testValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(-70, 1.70));
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(70, -1.70));
    }
}
