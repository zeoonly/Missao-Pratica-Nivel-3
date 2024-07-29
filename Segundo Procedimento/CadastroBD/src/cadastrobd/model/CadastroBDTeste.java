package cadastrobd.model;

import java.util.List;
import java.util.Scanner;

public class CadastroBDTeste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    incluir(scanner);
                    break;
                case 2:
                    alterar(scanner);
                    break;
                case 3:
                    excluir(scanner);
                    break;
                case 4:
                    exibirPorId(scanner);
                    break;
                case 5:
                    exibirTodos(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Incluir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Exibir pelo ID");
        System.out.println("5 - Exibir todos");
        System.out.println("0 - Finalizar");
        System.out.print("Selecione uma opção: ");
    }

    private static void incluir(Scanner scanner) {
        System.out.print("Tipo de Pessoa (Física/Jurídica): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Física")) {
            PessoaFisica pessoaFisica = new PessoaFisica();
            System.out.print("Nome: ");
            pessoaFisica.setNome(scanner.nextLine());
            System.out.print("Endereço: ");
            pessoaFisica.setEndereco(scanner.nextLine());
            System.out.print("Telefone: ");
            pessoaFisica.setTelefone(scanner.nextLine());
            System.out.print("Email: ");
            pessoaFisica.setEmail(scanner.nextLine());
            System.out.print("CPF: ");
            pessoaFisica.setCpf(scanner.nextLine());

            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            boolean inserido = pessoaFisicaDAO.incluir(pessoaFisica);

            if (inserido) {
                System.out.println("Pessoa física inserida com sucesso.");
            } else {
                System.out.println("Falha ao inserir pessoa física.");
            }
        } else if (tipo.equalsIgnoreCase("Jurídica")) {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            System.out.print("Nome: ");
            pessoaJuridica.setNome(scanner.nextLine());
            System.out.print("Endereço: ");
            pessoaJuridica.setEndereco(scanner.nextLine());
            System.out.print("Telefone: ");
            pessoaJuridica.setTelefone(scanner.nextLine());
            System.out.print("Email: ");
            pessoaJuridica.setEmail(scanner.nextLine());
            System.out.print("CNPJ: ");
            pessoaJuridica.setCnpj(scanner.nextLine());

            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            boolean inserido = pessoaJuridicaDAO.incluir(pessoaJuridica);

            if (inserido) {
                System.out.println("Pessoa jurídica inserida com sucesso.");
            } else {
                System.out.println("Falha ao inserir pessoa jurídica.");
            }
        } else {
            System.out.println("Tipo de pessoa inválido.");
        }
    }

    private static void alterar(Scanner scanner) {
        System.out.print("Tipo de Pessoa (Física/Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo.equalsIgnoreCase("Física")) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(id);

            if (pessoaFisica != null) {
                System.out.println("Dados atuais:");
                pessoaFisica.exibir();

                System.out.print("Novo Nome: ");
                pessoaFisica.setNome(scanner.nextLine());
                System.out.print("Novo Endereço: ");
                pessoaFisica.setEndereco(scanner.nextLine());
                System.out.print("Novo Telefone: ");
                pessoaFisica.setTelefone(scanner.nextLine());
                System.out.print("Novo Email: ");
                pessoaFisica.setEmail(scanner.nextLine());
                System.out.print("Novo CPF: ");
                pessoaFisica.setCpf(scanner.nextLine());

                boolean alterado = pessoaFisicaDAO.alterar(pessoaFisica);

                if (alterado) {
                    System.out.println("Dados alterados com sucesso.");
                } else {
                    System.out.println("Falha ao alterar os dados.");
                }
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("Jurídica")) {
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(id);

            if (pessoaJuridica != null) {
                System.out.println("Dados atuais:");
                pessoaJuridica.exibir();

                System.out.print("Novo Nome: ");
                pessoaJuridica.setNome(scanner.nextLine());
                System.out.print("Novo Endereço: ");
                pessoaJuridica.setEndereco(scanner.nextLine());
                System.out.print("Novo Telefone: ");
                pessoaJuridica.setTelefone(scanner.nextLine());
                System.out.print("Novo Email: ");
                pessoaJuridica.setEmail(scanner.nextLine());
                System.out.print("Novo CNPJ: ");
                pessoaJuridica.setCnpj(scanner.nextLine());

                boolean alterado = pessoaJuridicaDAO.alterar(pessoaJuridica);

                if (alterado) {
                    System.out.println("Dados alterados com sucesso.");
                } else {
                    System.out.println("Falha ao alterar os dados.");
                }
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo de pessoa inválido.");
        }
    }

    private static void excluir(Scanner scanner) {
        System.out.print("Tipo de Pessoa (Física/Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo.equalsIgnoreCase("Física")) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            boolean excluido = pessoaFisicaDAO.excluir(id);

            if (excluido) {
                System.out.println("Pessoa física excluída com sucesso.");
            } else {
                System.out.println("Falha ao excluir pessoa física.");
            }
        } else if (tipo.equalsIgnoreCase("Jurídica")) {
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            boolean excluido = pessoaJuridicaDAO.excluir(id);

            if (excluido) {
                System.out.println("Pessoa jurídica excluída com sucesso.");
            } else {
                System.out.println("Falha ao excluir pessoa jurídica.");
            }
        } else {
            System.out.println("Tipo de pessoa inválido.");
        }
    }

    private static void exibirPorId(Scanner scanner) {
        System.out.print("Tipo de Pessoa (Física/Jurídica): ");
        String tipo = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo.equalsIgnoreCase("Física")) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(id);

            if (pessoaFisica != null) {
                pessoaFisica.exibir();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("Jurídica")) {
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(id);

            if (pessoaJuridica != null) {
                pessoaJuridica.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo de pessoa inválido.");
        }
    }

    private static void exibirTodos(Scanner scanner) {
        System.out.print("Tipo de Pessoa (Física/Jurídica): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Física")) {
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            List<PessoaFisica> todasPessoasFisicas = pessoaFisicaDAO.getPessoas();

            for (PessoaFisica pf : todasPessoasFisicas) {
                pf.exibir();
                System.out.println();
            }
        } else if (tipo.equalsIgnoreCase("Jurídica")) {
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaDAO.getPessoas();

            for (PessoaJuridica pj : todasPessoasJuridicas) {
                pj.exibir();
                System.out.println();
            }
        } else {
            System.out.println("Tipo de pessoa inválido.");
        }
    }
}
