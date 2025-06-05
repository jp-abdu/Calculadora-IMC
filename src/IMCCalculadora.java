/**
  Classe para calcular o IMC.
  Fórmula IMC: IMC = peso / (altura * altura)
  Onde peso está em kg e altura em metros.
 */
public class IMCCalculadora {

    /**
      Calcula o IMC dado o peso e a altura.
      @param peso é Peso em quilogramas
      @param altura é Altura em metros
      @return O valor do IMC
      @throws IllegalArgumentException se peso ou altura forem inválidos
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
      Classifica o IMC
      @param imc é Valor do IMC
      @return String com a classificação
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

    /**
      Metodo principal para uso calculadora de IMC.
      Permite ao usuário inserir peso e altura.
     */

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        try {
            System.out.print("Digite o peso em kg: ");
            String pesoStr = scanner.next().replace(',', '.');
            double peso = Double.parseDouble(pesoStr);
            System.out.print("Digite a altura em metros: ");
            String alturaStr = scanner.next().replace(',', '.');
            double altura = Double.parseDouble(alturaStr);
            double imc = calcularIMC(peso, altura);
            String classificacao = classificarIMC(imc);
            System.out.printf("Seu IMC é: %.2f\n", imc);
            System.out.println("Classificação: " + classificacao);
        } catch (Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            scanner.close();
        }
    }
}
