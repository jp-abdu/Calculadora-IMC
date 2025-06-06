import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
  Classe de testes para IMCCalculadora.
  Utilizando JUnit 5 para validar o cálculo e classificação.
  Inclui testes de valor-limite e casos de exceção.
 */

public class IMCCalculadoraTest {

    /**
      Teste para IMC menor que 16 (baixo peso muito grave).
     */
    @Test
    void testIMCBaixoPesoMuitoGrave() {
        double imc = 15.9;
        assertEquals("Baixo peso muito grave", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }
    /**
      Teste para IMC entre 16 e 16,99 (baixo peso grave).
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
      Teste para IMC entre 17 e 18,49 (baixo peso).
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
      Teste para IMC entre 18,50 e 24,99 (peso normal).
     */
    @Test
    void testIMCPesoNormal() {
        double imc = 18.5;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }
    void testIMCPesoNormal2() {
        double imc = 24.9;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }
    /**
      Teste para IMC entre 25 e 29,99 (sobrepeso).
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
      Teste para IMC entre 30 e 34,99 (obesidade grau I).
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
      Teste para IMC entre 35 e 39,99 (obesidade grau II).
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
      Teste para IMC maior ou igual a 40 (obesidade grau III).
     */
    @Test
    void testIMCObesidadeGrauIII() {
        double imc = 40;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
    }

    /**
      Teste de exceção: peso zero.
     */
    @Test
    void testPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(0, 1.70));
    }

    /**
      Teste de exceção: altura zero.
     */
    @Test
    void testAlturaZero() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(70, 0));
    }

    /**
      Teste de exceção: valores negativos.
     */
    @Test
    void testValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(-70, 1.70));
        assertThrows(IllegalArgumentException.class, () -> IMCCalculadora.calcularIMC(70, -1.70));
    }


    // Testes para ADULTOS (idade < 60)
    @Test
    void testAdultoAbaixoDoPesoLimiteSuperior() {
        double imc = 18.4;
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
        assertEquals("Baixo peso", IMCCalculadora.classificarIMC(imc, 25, "feminino"));
    }
    @Test
    void testAdultoPesoNormalLimiteInferior() {
        double imc = 18.5;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 40, "masculino"));
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 20, "feminino"));
    }
    @Test
    void testAdultoPesoNormalLimiteSuperior() {
        double imc = 24.9;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 35, "masculino"));
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 50, "feminino"));
    }
    @Test
    void testAdultoSobrepesoLimiteInferior() {
        double imc = 25.0;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 45, "masculino"));
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 22, "feminino"));
    }
    @Test
    void testAdultoSobrepesoLimiteSuperior() {
        double imc = 29.9;
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 59, "masculino"));
        assertEquals("Sobrepeso", IMCCalculadora.classificarIMC(imc, 18, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauILimiteInferior() {
        double imc = 30.0;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 35, "masculino"));
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 25, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauILimiteSuperior() {
        double imc = 34.9;
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 40, "masculino"));
        assertEquals("Obesidade grau I", IMCCalculadora.classificarIMC(imc, 50, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauIILimiteInferior() {
        double imc = 35.0;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 30, "masculino"));
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 28, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauIILimiteSuperior() {
        double imc = 39.9;
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 45, "masculino"));
        assertEquals("Obesidade grau II", IMCCalculadora.classificarIMC(imc, 35, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauIIILimiteInferior() {
        double imc = 40.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 50, "masculino"));
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 32, "feminino"));
    }
    @Test
    void testAdultoObesidadeGrauIIILimiteSuperior() {
        double imc = 50.0;
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 35, "masculino"));
        assertEquals("Obesidade grau III", IMCCalculadora.classificarIMC(imc, 25, "feminino"));
    }

    // Testes para IDOSOS (idade >= 60)
    @Test
    void testIdosoAbaixoDoPesoLimiteSuperior() {
        double imc = 21.9;
        assertEquals("Abaixo do peso", IMCCalculadora.classificarIMC(imc, 65, "masculino"));
        assertEquals("Abaixo do peso", IMCCalculadora.classificarIMC(imc, 80, "feminino"));
    }
    @Test
    void testIdosoPesoNormalLimiteInferior() {
        double imc = 22.0;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 70, "masculino"));
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 90, "feminino"));
    }
    @Test
    void testIdosoPesoNormalLimiteSuperior() {
        double imc = 26.9;
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 75, "masculino"));
        assertEquals("Peso normal", IMCCalculadora.classificarIMC(imc, 85, "feminino"));
    }
    @Test
    void testIdosoExcessoDePesoLimiteInferior() {
        double imc = 27.0;
        assertEquals("Excesso de peso", IMCCalculadora.classificarIMC(imc, 68, "masculino"));
        assertEquals("Excesso de peso", IMCCalculadora.classificarIMC(imc, 95, "feminino"));
    }
    @Test
    void testIdosoExcessoDePesoLimiteSuperior() {
        double imc = 35.0;
        assertEquals("Excesso de peso", IMCCalculadora.classificarIMC(imc, 80, "masculino"));
        assertEquals("Excesso de peso", IMCCalculadora.classificarIMC(imc, 100, "feminino"));
    }
}
