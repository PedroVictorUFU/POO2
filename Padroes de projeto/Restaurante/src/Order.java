import java.util.ArrayList;

/**
 * Created by Syane on 16/06/2016.
 */
public class Order {
    private int num;
    private Table table;
    private Garcon garcon;
    private State state;
    private ArrayList<Item>itensOrder = new ArrayList<Item>();
    private Kitchen kitchen;
    private double total;

    public Order(int num, Table table, Garcon garcon){
        this.num = num;
        this.table = table;
        this.garcon = garcon;
        this.state = new EmEspera(this);
    }

    //Getters e Setters dos atributos da Classe
    public void setNum(int num) {
        this.num = num;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setGarcon(Garcon garcon) {
        this.garcon = garcon;
    }

    public void setItensOrder(Item item) { this.itensOrder.add(item); }

    public void setKitchen(Kitchen kitchen) { this.kitchen = kitchen; }

    public void setState(State state) { this.state = state; }

    public void setTotal(double total) {this.total = total; }


    public Garcon getGarcon() {
        return this.garcon;
    }

    public int getNum() {
        return this.num;
    }

    public Table getTable() { return this.table; }

    public Kitchen getKitchen() { return this.kitchen; }

    public State getState() { return this.state; }

    public double getTotal() { return this.total; }

    //Adcionando e retirando iitens do meu pedido
    public ArrayList<Item> getItensOrder(){ return this.itensOrder; }

    public void removeItemList(Item item){ this.itensOrder.remove(item); }
}

