package cadastrobd.model;

public class Pessoa {
    private int pessoaID;
    private String tipoPessoa; // "Fisica" ou "Juridica"
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    // Construtor padrão
    public Pessoa() {}

    // Construtor completo
    public Pessoa(int pessoaID, String tipoPessoa, String nome, String endereco, String telefone, String email) {
        this.pessoaID = pessoaID;
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para exibir os dados no console
    public void exibir() {
        System.out.println("PessoaID: " + pessoaID);
        System.out.println("TipoPessoa: " + tipoPessoa);
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}
