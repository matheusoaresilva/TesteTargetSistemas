package ExFaturamentoEstado;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
    4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

    SP – R$67.836,43
    RJ – R$36.678,66
    MG – R$29.229,88
    ES – R$27.165,48
    Outros – R$19.849,53

    Escreva um programa na linguagem que desejar onde calcule o percentual
    de representação que cada estado teve dentro do valor total mensal da distribuidora.
     */
    public static void main(String[] args) {
        // Definindo o faturamento mensal por estado
        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        // Calculando o faturamento total mensal da distribuidora
        double faturamentoTotal = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

        // Calculando e imprimindo o percentual de representação de cada estado no faturamento total
        DecimalFormat df = new DecimalFormat("#0.00%");
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            double percentual = entry.getValue() / faturamentoTotal;
            System.out.println(entry.getKey() + " - " + df.format(percentual));
        }
    }

}
