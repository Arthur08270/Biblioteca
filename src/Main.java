import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    static String connectionString = "jdbc:sqlite:exemplo.db";

    static void main() {
        createTable();

        Scanner scanner = new Scanner(System.in);

        var opcao = 0;
        do {
            exibirMenu();
            System.out.println("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
//                case 1 -> inserirDados();
//                case 2 -> consultarTodos();
//                case 3 -> buscarAluno();
//                case 4 -> atualizarAluno();
//                case 5 -> excluirAluno();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("        SISTEMA DE ALUNOS        ");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Buscar aluno");
        System.out.println("4 - Atualizar aluno");
        System.out.println("5 - Excluir aluno");
        System.out.println("0 - Sair");
        System.out.println("=================================");
        System.out.println();
    }

    private static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS Unit (
                    id PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    endereco TEXT NOT NULL,
                    email TEXT NOT NULL
                );
                CREATE TABLE IF NOT EXISTS User (
                    id PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    CPF TEXT NOT NULL,
                    matricula INTERGER NOT NULL,
                    email TEXT NOT NULL
                );
                CREATE TABLE IF NOT EXISTS Book (
                    id PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    autor TEXT NOT NULL,
                    ISBN TEXT NOT NULL,
                    anoPublicacao DATE NOT NULL,
                    qntDisponivel INTEGER NOT NULL
                );
                """;
        try (var connection = DriverManager.getConnection(connectionString)) {
            var statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            System.out.println("Não consegui criar a tabela");
        }
    }
}
