/**
 * Created by Syane on 18/06/2016.
 */
//Decorator
public abstract class ItemDecorado extends Item {

    private Item itemDecorado;

    //Construtor da classe
    public ItemDecorado(Item itemDecorado){ this.itemDecorado = itemDecorado; }

    public String getNome(){
        return this.itemDecorado.getNome()+ " " + super.getNome();
    }

    public double getPreco(){
        return this.itemDecorado.getPreco() + super.getPreco();
    }
}
