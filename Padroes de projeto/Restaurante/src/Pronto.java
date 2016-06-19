/**
 * Created by Syane on 18/06/2016.
 */
public class Pronto extends State {

    public Pronto(Order order){
        super(order, "Pronto");
    }

    public String mostraEstado(){
        return this.getState() + " para servir";
    }

    //Como o pedido já esta pronto, então nenhuma modificação pode ser feito no anterior
    public void retiraItem(Item item){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    //Mas podera add itens
    public void addItem (Item item) {
        this.getOrder().setItensOrder(item);
        this.getOrder().setState(new EmEspera(this.getOrder()));
    }

    public void cancelOrder(){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void chageState() {
        this.getOrder().setState(new Fechado(this.getOrder()));
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
