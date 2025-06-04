/**
 * Classe para calcular o IMC (Índice de Massa Corporal).
 * O IMC é calculado pela fórmula: IMC = peso / (altura * altura)
 * Onde peso está em kg e altura em metros.
 */
public class IMCCalculadora {
    /**
     * Calcula o IMC dado o peso e a altura.
     * @param peso Peso em quilogramas
     * @param altura Altura em metros
     * @return O valor do IMC
     * @throws IllegalArgumentException se peso ou altura forem inválidos
     */
    public static double calcularIMC(double peso, double altura) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        return peso / (altura * altura);
    }

    /**
     * Classifica o IMC de acordo com a tabela da OMS.
     * @param imc Valor do IMC
     * @return String com a classificação
     */
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau I";
        } else if (imc < 40) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}
