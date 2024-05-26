import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lgames {
    static class Jogo implements Serializable {
        String nome;
        double preco;

        public Jogo(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }
    }

    public static void main(String[] args) {
        List<Jogo> jogos = carregarDados();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar novo jogo");
            System.out.println("2. Listar jogos");
            System.out.println("3. Atualizar jogo");
            System.out.println("4. Deletar jogo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarJogo(scanner, jogos);
                    break;
                case 2:
                    listarJogos(jogos);
                    break;
                case 3:
                    atualizarJogo(scanner, jogos);
                    break;
                case 4:
                    deletarJogo(scanner, jogos);
                    break;
                case 5:
                    salvarDados(jogos);
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    @SuppressWarnings("unchecked")
    static List<Jogo> carregarDados() {
        List<Jogo> jogos = new ArrayList<>();
        File arquivo = new File("jogos.txt");
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                jogos = (List<Jogo>) ois.readObject();
                System.out.println("Dados carregados com sucesso.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar os dados: " + e.getMessage());
            }
        } else {
            System.out.println("Arquivo 'jogos.txt' não encontrado. Criando novo arquivo.");
        }
        return jogos;
    }

    static void salvarDados(List<Jogo> jogos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jogos.txt"))) {
            oos.writeObject(jogos);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    static void criarJogo(Scanner scanner, List<Jogo> jogos) {
        System.out.print("Nome do jogo: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine();
        System.out.print("Preço do jogo: ");
        double preco = scanner.nextDouble();

        Jogo novoJogo = new Jogo(nome, preco);
        jogos.add(novoJogo);
        System.out.println("\nJogo criado com sucesso.");
    }

    static void listarJogos(List<Jogo> jogos) {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.println("Lista de jogos:");
            for (int i = 0; i < jogos.size(); i++) {
                System.out.println((i + 1) + ". " + jogos.get(i).nome + " - Preço: R$" + jogos.get(i).preco);
            }
        }
    }

    static void atualizarJogo(Scanner scanner, List<Jogo> jogos) {
        listarJogos(jogos);
        if (!jogos.isEmpty()) {
            System.out.print("Selecione o número do jogo a ser atualizado: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < jogos.size()) {
                System.out.print("Novo nome do jogo: ");
                scanner.nextLine(); 
                String nome = scanner.nextLine();
                System.out.print("Novo preço do jogo: ");
                double preco = scanner.nextDouble();

                jogos.get(index).nome = nome;
                jogos.get(index).preco = preco;
                System.out.println("Jogo atualizado com sucesso.");
            } else {
                System.out.println("Número de jogo inválido.");
            }
        }
    }

    static void deletarJogo(Scanner scanner, List<Jogo> jogos) {
        listarJogos(jogos);
        if (!jogos.isEmpty()) {
            System.out.print("Selecione o número do jogo a ser deletado: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < jogos.size()) {
                jogos.remove(index);
                System.out.println("Jogo deletado com sucesso.");
            } else {
                System.out.println("Número de jogo inválido.");
            }
        }
    }
}
