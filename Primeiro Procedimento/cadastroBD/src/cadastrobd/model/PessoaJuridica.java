package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super();
    }

    // Construtor completo
    public PessoaJuridica(int pessoaID, String nome, String endereco, String telefone, String email, String cnpj) {
        super(pessoaID, "J", nome, endereco, telefone, email); // Define tipoPessoa como "Juridica"
        this.cnpj = cnpj;
    }

    // Getter e Setter para CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Sobrescrevendo o método exibir para incluir CNPJ
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Cnpj: " + cnpj);
    }
}
