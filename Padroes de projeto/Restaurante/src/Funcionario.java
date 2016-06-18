/**
 * Created by Syane on 16/06/2016.
 */
public abstract class Funcionario {

    private int num;
    private String nome;
    private String RG;
    private String endereco;
    private String telefone;

    public Funcionario(int num,String nome, String RG,String endereco, String telefone){
        this.num = num;
        this.nome = nome;
        this.RG = RG;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
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
}
