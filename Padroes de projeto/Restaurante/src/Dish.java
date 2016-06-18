/**
 * Created by Syane on 18/06/2016.
 */
public class Dish extends Item {

    //Construtor da classe
    public Dish(String Nome, double preco){
        super.setNome(Nome);
        super.setPreco(preco);
        super.setMododePreparo(new MododePreparo1());
    }

    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
}
