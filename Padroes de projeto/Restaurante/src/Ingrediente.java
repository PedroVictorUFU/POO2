/**
 * Created by Syane on 18/06/2016.
 */
//ConcreteDecorator
public class Ingrediente extends ItemDecorado {

    public Ingrediente(Item itemDecorado,String nome, double preco){
        super(itemDecorado);
        setNome(nome);
        setPreco(preco);
    }
}
