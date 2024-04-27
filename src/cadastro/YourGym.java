package cadastro;

import java.util.Arrays;
import java.util.Scanner;

public class YourGym {

    public enum Plano {

        Basic("Basic", 129.99, "Mensal", "Convidar uma pessoa para treino 5 vezes por mês."),
        Master("Master", 279.99, "Trimestral", "Treinar em qualquer unidade Convidado 5 vezes por mês"),
        Platinum("Platinum", 879.99, "Anual", "Treinar em qualquer unidade Convidado 5 vezes por mês");

        final String nome;
        final double valor;
        final String duracao;
        final String beneficios;

        //Construtor

        Plano(String nome, double valor, String duracao, String beneficios) {
            this.nome = nome;
            this.valor = valor;
            this.duracao = duracao;
            this.beneficios = beneficios;
        }

        @Override
        public String toString() {
            return "Plano: " + nome + "\nValor: " + valor + "\nDuração: " + duracao + "\nBeneficios: " + beneficios + "\n";
        }
    }

    public static void main(String[] args) {
        //Instanciando objetos:
        Scanner sc = new Scanner(System.in);

        //Declaração de variáveis:
        Plano planoSelecionado = null;
        boolean confirmar = false;
        System.out.println("-----------=*|*=----------");
        System.out.println("|| Bem vindo a YourGym ||");
        System.out.println("-----------=*|*=----------");


        //Loop para seleção:

        while (!Arrays.asList(Plano.values()).contains(planoSelecionado) || !confirmar) {
            System.out.println("Por favor, selecione um plano:");
            for (Plano value : Plano.values()) {

                System.out.println(value);

            }
            System.out.println("Escolha entre: Basic, Master, Platinum");

            /*
             *Tratamento de exceções
             *toda vez que existe um Throw no código, é por que está sendo jogada uma exceção.
             *Erro = Erro do usuário
             *Exceções = erro do programador
             */

            try {
                planoSelecionado = Plano.valueOf(sc.nextLine());

                /*
                 * O valueOf tenta pegar algum dos valores da enum baseado em uma String
                 * Caso não esteja escrito exatamente igual ao valor, será jogada uma exceção:
                 * IllegalArgumentException
                 */

                System.out.println(planoSelecionado);

                System.out.println("Você selecionou o plano " + planoSelecionado.nome + "\nConfirma?(S / N)");
                switch (sc.nextLine().toLowerCase()) {
                    case "s":
                        confirmar = true;
                        System.out.println("Seleção confirmada! Bem vindo à nossa rede! Po\uD83C\uDFCB\uFE0F");
                        break;
                    case "n":
//                    Não faz nada
                        break;
                    default:
                        System.err.println("Por favor, escolha entre S e N");
                        break;
                }
            } catch (IllegalArgumentException _) {
                System.err.println("Valor invalido, escolha entre os planos disponíveis");
            }
        }
    }
}
