import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
  Classe de testes para IMCCalculadora.
  Utilizando JUnit 5 para validar o cálculo e classificação.
  Inclui testes de valor-limite e casos de exceção.
 */

public class IMCCalculadoraTest {

    /**
     * Teste para IMC menor que 16 (baixo peso muito grave).
     */
    @Test
    void testIMCBaixoPesoMuitoGrave() {
        double imc = 15.9;
        assertEquals("Baixo peso muito grave", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 16 e 16,99 (baixo peso grave).
     */
    @Test
    void testIMCBaixoPesoGrave() {
        double imc = 16;
        assertEquals("Baixo peso grave", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCBaixoPesoGrave2() {
        double imc = 16.9;
        assertEquals("Baixo peso grave", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 17 e 18,49 (baixo peso).
     */
    @Test
    void testIMCBaixoPeso() {
        double imc = 17;
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCBaixoPeso2() {
        double imc = 18.4;
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 18,50 e 24,99 (peso normal).
     */
    @Test
    void testIMCPesoNormal() {
        double imc = 18.5;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCPesoNormal2() {
        double imc = 24.9;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 25 e 29,99 (sobrepeso).
     */
    @Test
    void testIMCSobrepeso() {
        double imc = 25;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCSobrepeso2() {
        double imc = 29.9;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 30 e 34,99 (obesidade grau I).
     */
    @Test
    void testIMCObesidadeGrauI() {
        double imc = 30.0;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCObesidadeGrauI2() {
        double imc = 34.9;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC entre 35 e 39,99 (obesidade grau II).
     */
    @Test
    void testIMCObesidadeGrauII() {
        double imc = 35.0;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    @Test
    void testIMCObesidadeGrauII2() {
        double imc = 39.9;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
     * Teste para IMC maior ou igual a 40 (obesidade grau III).
     */
    @Test
    void testIMCObesidadeGrauIII() {
        double imc = 40;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
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

    // Testes para IDOSAS (mulheres, idade >= 65)
    @Test
    void testIdosaBaixoPeso() {
        double imc = 21.8;
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaPesoNormalLimiteInferior() {
        double imc = 22.0;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaPesoNormalLimiteSuperior() {
        double imc = 27.0;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaSobrepesoLimiteInferior() {
        double imc = 27.1;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaSobrepesoLimiteSuperior() {
        double imc = 32.0;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauILimiteInferior() {
        double imc = 32.1;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauILimiteSuperior() {
        double imc = 37.0;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauIILimiteInferior() {
        double imc = 37.1;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauIILimiteSuperior() {
        double imc = 41.9;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauIIILimiteInferior() {
        double imc = 42.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }
    @Test
    void testIdosaObesidadeGrauIIILimiteSuperior() {
        double imc = 50.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 70, "feminino"));
    }

    // Testes para IDOSOS (homens, idade >= 65)
    @Test
    void testIdosoBaixoPeso() {
        double imc = 21.8;
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoPesoNormalLimiteInferior() {
        double imc = 22.0;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoPesoNormalLimiteSuperior() {
        double imc = 27.0;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoSobrepesoLimiteInferior() {
        double imc = 27.1;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoSobrepesoLimiteSuperior() {
        double imc = 30.0;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauILimiteInferior() {
        double imc = 30.1;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauILimiteSuperior() {
        double imc = 35.0;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauIILimiteInferior() {
        double imc = 35.1;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauIILimiteSuperior() {
        double imc = 39.9;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauIIILimiteInferior() {
        double imc = 40.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
    @Test
    void testIdosoObesidadeGrauIIILimiteSuperior() {
        double imc = 50.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
    }
}