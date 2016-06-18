/**
 * Created by Syane on 18/06/2016.
 */
//ConcreteComponent
public class Beverage extends Item {

    //Construtor da classe
    public Beverage(String nome, double preco){
        super.setNome(nome);
        super.setPreco(preco);
        super.setMododePreparo(new MododePreparo1());
    }
}
