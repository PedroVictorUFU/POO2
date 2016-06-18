/**
 * Created by Syane on 18/06/2016.
 */
//ConcreteComponent
public class IndustrializedBeverage extends Item {

    public IndustrializedBeverage(String nome, double preco){
        setPreco(preco);
        setNome(nome);
        setMododePreparo(new MododePreparo2());
    }

}
