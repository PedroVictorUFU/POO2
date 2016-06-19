/**
 * Created by Syane on 18/06/2016.
 */
public class EmPreparo extends State {

    //Somente a adção de item ao pedido poderá ser feita, Mudancas em item ou retirar itens que ja estão em preparo nao podera ser feito
    public EmPreparo(Order order){
        super(order,"Em Preparo");
    }

    public String mostraEstado(){
       return this.getState() + " Só poderá adcionar itens a esse pedido. ";
    }

    public void retiraItem(Item item){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void addItem (Item item) { this.getOrder().setItensOrder(item); }

    public void cancelOrder(){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void chageState() {
        this.getOrder().setState(new Pronto(this.getOrder()));
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
