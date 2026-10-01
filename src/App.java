import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Lancamento> lancamentos = new ArrayList<>();

        int proximoId = 1;
        int opcao;

        do {

            System.out.println("\n=== CONTROLE FINANCEIRO ===");
            System.out.println("1 - Cadastrar receita");
            System.out.println("2 - Cadastrar despesa");
            System.out.println("3 - Listar lançamentos");
            System.out.println("4 - Ver saldo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n=== NOVA RECEITA ===");

                    System.out.print("Descrição: ");
                    String descricaoReceita = scanner.nextLine();

                    System.out.print("Valor: R$ ");
                    double valorReceita = scanner.nextDouble();
                    scanner.nextLine();

                    Lancamento receita = new Lancamento(
                        proximoId,
                        descricaoReceita,
                        valorReceita,
                        "Receita"
                    );

                    lancamentos.add(receita);

                    System.out.println("Receita cadastrada!");
                    System.out.println("ID: " + proximoId);

                    proximoId++;

                    break;

                case 2:

                    System.out.println("\n=== NOVA DESPESA ===");

                    System.out.print("Descrição: ");
                    String descricaoDespesa = scanner.nextLine();

                    System.out.print("Valor: R$ ");
                    double valorDespesa = scanner.nextDouble();
                    scanner.nextLine();

                    Lancamento despesa = new Lancamento(
                        proximoId,
                        descricaoDespesa,
                        valorDespesa,
                        "Despesa"
                    );

                    lancamentos.add(despesa);

                    System.out.println("Despesa cadastrada!");
                    System.out.println("ID: " + proximoId);

                    proximoId++;

                    break;

                case 3:

                    System.out.println("\n=== LANÇAMENTOS ===");

                    if (lancamentos.isEmpty()) {

                        System.out.println("Nenhum lançamento cadastrado.");

                    } else {

                        for (Lancamento lancamento : lancamentos) {

                            System.out.println("ID: " + lancamento.getId());
                            System.out.println("Descrição: " + lancamento.getDescricao());
                            System.out.println("Valor: R$ " + lancamento.getValor());
                            System.out.println("Tipo: " + lancamento.getTipo());
                            System.out.println("-------------------------");
                        }
                    }

                    break;

                case 4:

                    double totalReceitas = 0;
                    double totalDespesas = 0;

                    for (Lancamento lancamento : lancamentos) {

                        if (lancamento.getTipo().equals("Receita")) {
                            totalReceitas += lancamento.getValor();

                        } else if (lancamento.getTipo().equals("Despesa")) {
                            totalDespesas += lancamento.getValor();
                        }
                    }

                    double saldo = totalReceitas - totalDespesas;

                    System.out.println("\n=== RESUMO FINANCEIRO ===");
                    System.out.printf("Total de receitas: R$ %.2f%n", totalReceitas);
                    System.out.printf("Total de despesas: R$ %.2f%n", totalDespesas);
                    System.out.printf("Saldo: R$ %.2f%n", saldo);

                    break;

                case 5:

                    System.out.println("\nSistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}