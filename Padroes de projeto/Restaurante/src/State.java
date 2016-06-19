/**
 * Created by Syane on 18/06/2016.
 */
//State
public abstract class State {
    private Order order;
    private String state;

    public State(Order order, String state){
        this.order = order;
        this.state = state;
    }

    public Order getOrder(){ return this.order; }

    public String getState() { return this.state; }

    public void setOrder(Order order) { this.order = order; }

    //Mudanca de estado do pedido
    protected abstract void chageState();

    //Mostra em que estado o pedido esta e o que pode ser modificado
    public abstract String mostraEstado();

    //retira algum item do pedido
    public abstract void retiraItem(Item item);

    //Adciona item ao pedido
    public abstract void addItem (Item item) ;

    //Cancela o pedido na lista da cozinha
    public abstract void cancelOrder();

    //Fecha a conta e da o total a ser pago
    public abstract void fechaConta();
}
