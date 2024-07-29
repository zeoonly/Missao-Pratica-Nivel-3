    package cadastrobd.model;

    import java.util.List;

    public class CadastroBDTeste {

        public static void main(String[] args) {
            // Testando operações com Pessoa Física
            testarOperacoesPessoaFisica();

            // Testando operações com Pessoa Jurídica
            testarOperacoesPessoaJuridica();
        }

        private static void testarOperacoesPessoaFisica() {
            // Criando uma pessoa física para teste
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setNome("Paulo amancio");
            pessoaFisica.setEndereco("Rua valdemar 001");
            pessoaFisica.setTelefone("(48) 99999-9999");
            pessoaFisica.setEmail("Paulo@gmail.com");
            pessoaFisica.setCpf("12304578900");

            // Persistindo a pessoa física no banco de dados
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
            boolean inserido = pessoaFisicaDAO.incluir(pessoaFisica);

            if (inserido) {
                System.out.println("Pessoa física inserida com sucesso no banco de dados.");
            } else {
                System.out.println("Falha ao inserir pessoa física no banco de dados.");
                return;
            }

            // Alterando os dados da pessoa física
            pessoaFisica.setEndereco("Rua Afonso pena, 002");
            boolean alterado = pessoaFisicaDAO.alterar(pessoaFisica);

            if (alterado) {
                System.out.println("Dados da pessoa física alterados com sucesso.");
            } else {
                System.out.println("Falha ao alterar dados da pessoa física.");
            }

            // Consultando todas as pessoas físicas do banco de dados e listando no console
            List<PessoaFisica> todasPessoasFisicas = pessoaFisicaDAO.getPessoas();
            System.out.println("\nLista de Pessoas Físicas:");
            for (PessoaFisica pf : todasPessoasFisicas) {
                pf.exibir();
            }

            // Excluindo a pessoa física criada anteriormente do banco de dados
            boolean excluido = pessoaFisicaDAO.excluir(pessoaFisica.getPessoaID());

            if (excluido) {
                System.out.println("Pessoa física excluída com sucesso do banco de dados.");
            } else {
                System.out.println("Falha ao excluir pessoa física do banco de dados.");
            }
        }

        private static void testarOperacoesPessoaJuridica() {
            // Criando uma pessoa jurídica para teste
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setNome("JR  Ltda");
            pessoaJuridica.setEndereco("Rua Joaquin, 001");
            pessoaJuridica.setTelefone("(48) 99999-8888");
            pessoaJuridica.setEmail("JR@gmail.com");
            pessoaJuridica.setCnpj("12345678000190");

            // Persistindo a pessoa jurídica no banco de dados
            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
            boolean inserido = pessoaJuridicaDAO.incluir(pessoaJuridica);

            if (inserido) {
                System.out.println("\nPessoa jurídica inserida com sucesso no banco de dados.");
            } else {
                System.out.println("\nFalha ao inserir pessoa jurídica no banco de dados.");
                return;
            }

            // Alterando os dados da pessoa jurídica
            pessoaJuridica.setEndereco("Rua Manoel rosa, 002");
            boolean alterado = pessoaJuridicaDAO.alterar(pessoaJuridica);

            if (alterado) {
                System.out.println("Dados da pessoa jurídica alterados com sucesso.");
            } else {
                System.out.println("Falha ao alterar dados da pessoa jurídica.");
            }

            // Consultando todas as pessoas jurídicas do banco de dados e listando no console
            List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaDAO.getPessoas();
            System.out.println("\nLista de Pessoas Jurídicas:");
            for (PessoaJuridica pj : todasPessoasJuridicas) {
                pj.exibir();
            }

            // Excluindo a pessoa jurídica criada anteriormente do banco de dados
            boolean excluido = pessoaJuridicaDAO.excluir(pessoaJuridica.getPessoaID());

            if (excluido) {
                System.out.println("Pessoa jurídica excluída com sucesso do banco de dados.");
            } else {
                System.out.println("Falha ao excluir pessoa jurídica do banco de dados.");
            }
        }
    }
