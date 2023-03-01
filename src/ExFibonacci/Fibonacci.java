package ExFibonacci;

import java.util.Scanner;

public class Fibonacci {

    /*
    2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o
    próximo valor sempre será a soma dos 2 valores anteriores
    (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um
    programa na linguagem que desejar onde, informado um número,
    ele calcule a sequência de Fibonacci e retorne uma mensagem
    avisando se o número informado pertence ou não a sequência.
 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // pede ao usuário para informar um número
        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int num = input.nextInt();

        // variáveis para armazenar os valores de Fibonacci
        int anterior = 0;
        int atual = 1;
        int proximo = 0;

        // loop para calcular a sequência de Fibonacci
        while (proximo < num) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        // verifica se o número informado pertence à sequência
        if (proximo == num) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
    }
}
