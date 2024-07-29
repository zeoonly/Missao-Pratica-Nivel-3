package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    // Construtor padrão
    public PessoaFisica() {
        super();
    }

    // Construtor completo
    public PessoaFisica(int pessoaID, String nome, String endereco, String telefone, String email, String cpf) {
        super(pessoaID, "F", nome, endereco, telefone, email); // Define tipoPessoa como "Fisica"
        this.cpf = cpf;
    }

    // Getter e Setter para CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Sobrescrevendo o método exibir para incluir CPF
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Cpf: " + cpf);
    }
}