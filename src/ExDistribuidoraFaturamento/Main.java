import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        try {
            // Lendo o arquivo JSON
            FileReader reader = new FileReader("C:\\temp\\dados.json");

            // Convertendo o JSON para uma matriz de objetos do tipo Venda
            Venda[] vendas = gson.fromJson(reader, Venda[].class);
            if (vendas != null) {
                // Realizando os cálculos
                double menorFaturamentoDiario = calcularMenorFaturamentoDiario(vendas);
                double maiorFaturamentoDiario = calcularMaiorFaturamentoDiario(vendas);
                int diasAcimaDaMedia = calcularDiasAcimaDaMedia(vendas);
                // Imprimindo os resultados
                imprimirResultados(menorFaturamentoDiario, maiorFaturamentoDiario, diasAcimaDaMedia, df);
            } else {
                System.out.println("O array de vendas é nulo.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo JSON não foi encontrado.");
        } catch (Exception e) {
            System.out.println("Erro ao ler ou analisar o arquivo JSON.");
            e.printStackTrace();
        }
    }


    private static double calcularMenorFaturamentoDiario(Venda[] vendas) {
        double menorFaturamentoDiario = vendas[0].valor;
        for (Venda venda : vendas) {
            if (venda.valor < menorFaturamentoDiario) {
                menorFaturamentoDiario = venda.valor;
            }
        }
        return menorFaturamentoDiario;
    }


    private static double calcularMaiorFaturamentoDiario(Venda[] vendas) {
        double maiorFaturamentoDiario = vendas[0].valor;
        for (Venda venda : vendas) {
            if (venda.valor > maiorFaturamentoDiario) {
                maiorFaturamentoDiario = venda.valor;
            }
        }
        return maiorFaturamentoDiario;
    }


    private static int calcularDiasAcimaDaMedia(Venda[] vendas) {
        double totalFaturamento = 0;
        for (Venda venda : vendas) {
            totalFaturamento += venda.valor;
        }
        double mediaMensal = totalFaturamento / vendas.length * 30;
        int diasAcimaDaMedia = 0;
        for (Venda venda : vendas) {
            if (venda.valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }
        return diasAcimaDaMedia;


    }

    private static void imprimirResultados(double menorValor, double maiorValor, int diasAcimaMedia, DecimalFormat df) {
        System.out.println("Menor valor de faturamento diário: R$ " + df.format(menorValor));
        System.out.println("Maior valor de faturamento diário: R$ " + df.format(maiorValor));
        System.out.println("Dias com faturamento acima da média mensal: " + diasAcimaMedia);
    }

}
