/**
  Classe para calcular o IMC.
  Fórmula IMC: IMC = peso / (altura * altura)
  Onde peso está em kg e altura em metros.
 */
public class IMCCalculadora {

    /**
      Calcula o IMC dado o peso e a altura.
      Peso em quilogramas
      Altura em metros
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
      Classifica o IMC considerando idade e gênero.
      @param imc valor do IMC
      @param idade idade da pessoa
      @param genero gênero da pessoa ("masculino" ou "feminino")
      @return String com a classificação
     */
    public static String classificarIMC(double imc, int idade, String genero) {
        // Classificação para adultos (OMS)
        if (idade < 60) {
            if (imc < 16) {
                return "Baixo peso muito grave";
            } else if (imc < 17) {
                return "Baixo peso grave";
            } else if (imc < 18.5) {
                return "Baixo peso";
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
        } else {
            // Idoso: manter classificação anterior (pode ser ajustada se desejar)
            if (imc < 22) {
                return "Abaixo do peso";
            } else if (imc < 27) {
                return "Peso normal";
            } else {
                return "Excesso de peso";
            }
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
            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o gênero (masculino/feminino): ");
            String genero = scanner.next();
            double imc = calcularIMC(peso, altura);
            String classificacao = classificarIMC(imc, idade, genero);
            System.out.printf("Seu IMC é: %.2f\n", imc);
            System.out.println("Classificação: " + classificacao);
        } catch (Exception erro) {
            System.out.println("Erro: " + erro.getMessage());
        } finally {
            scanner.close();
        }
    }
}
