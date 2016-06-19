/**
 * Created by Syane on 19/06/2016.
 */
public class Fechado extends State {

    public Fechado(Order order){
        super(order, "Fechado");
    }

    //
    public void fechaConta(){
        double soma = 0.;
        System.out.println("Lista de Itens pedido");
        for(Item item: this.getOrder().getItensOrder()){
            System.out.println("Item: " + item.getNome() + " Valor: " + item.getPreco());
            soma = soma + item.getPreco();
        }
        this.getOrder().setTotal(soma);
        System.out.println("Total do Pedido: " + soma);
    }

    public String mostraEstado(){
        return this.getState() + " Nenhuma modificacao pode ser feita, seu pedido ja esta Fechado! ";
    }

    public void retiraItem(Item item){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void addItem (Item item) { System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void cancelOrder(){ System.out.println("[ACESSO NEGADO] " + this.mostraEstado()); }

    public void chageState() {
        //this.getOrder().setState(new EmPreparo(this.getOrder()));
        System.out.println("[ACESSO NEGADO] " + this.mostraEstado());
    }
}
