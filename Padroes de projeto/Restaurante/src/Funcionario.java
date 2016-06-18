/**
 * Created by Syane on 16/06/2016.
 */
public class Funcionario {

    //Classe para todos os funcionarios
    private int num;
    private String nome;
    private String RG;
    private String endereco;
    private String telefone;

    //Construtor da classe
    public Funcionario(int num,String nome, String RG,String endereco, String telefone){
        this.num = num;
        this.nome = nome;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
    }


//Setters e getters dos atributos

    public void setNum(int num) {
        this.num = num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRG(String RG) { this.RG = RG; }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getNum() {
        return this.num;
    }

    public String getRG() {
        return this.RG;
    }

    public String getNome() {
        return this.nome;
    }

}
