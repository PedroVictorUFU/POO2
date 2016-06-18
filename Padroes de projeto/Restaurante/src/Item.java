/**
 * Created by Syane on 18/06/2016.
 */

//Component
public abstract class Item {

    private String nome;
    private double preco;
    private MododePreparo mododePreparo;

    //Getters e Setters dos atributos da classe

    public String getNome() { return this.nome; }


    public double getPreco(){ return this.preco; }

    public void setNome(String nome) { this.nome = nome; }

    public void setPreco(double preco) { this.preco = preco; }

    public void setMododePreparo(MododePreparo mododePreparo) { this.mododePreparo = mododePreparo; }

    public void modoDePreparo() {
       mododePreparo.mododePreparo();
    }
}

