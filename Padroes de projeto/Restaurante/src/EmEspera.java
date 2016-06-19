import com.sun.media.sound.EmergencySoundbank;

/**
 * Created by Syane on 18/06/2016.
 */
//Concrete State
public class EmEspera extends State {

    //Nesse estado todas as modificações em pedido estão em aberto
    public EmEspera(Order order){
        super(order, "Em Espera");
    }

    public String mostraEstado(){
        return this.getState() + "Modificações podem ser feitas.";
    }

    public void retiraItem(Item item){ this.getOrder().removeItemList(item); }

    public void addItem (Item item) { this.getOrder().setItensOrder(item); }

    public void cancelOrder(){ this.getOrder().getGarcon().cancelOrder(this.getOrder().getTable(),this.getOrder().getKitchen()); }

    public void chageState() {
        this.getOrder().setState(new EmPreparo(this.getOrder()));
    }

    public void fechaConta(){
        double soma = 0.;
        System.out.println("Lista de Itens pedido");
        for(Item item: this.getOrder().getItensOrder()){
            System.out.println("Item: " + item.getNome() + " Valor: " + item.getPreco());
            soma = soma + item.getPreco();
        }
        this.getOrder().setTotal(soma);
        System.out.println("Total do Pedido: " + soma);
        this.getOrder().setState(new Fechado(this.getOrder()));
    }
}
