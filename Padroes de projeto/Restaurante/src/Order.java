/**
 * Created by Syane on 16/06/2016.
 */
public class Order {
    private int num;
    private Table table;
    private Garcon garcon;

    public Order(int num, Table table, Garcon garcon){
        this.num = num;
        this.table = table;
        this.garcon = garcon;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setGarcon(Garcon garcon) {
        this.garcon = garcon;
    }

    public Garcon getGarcon() {
        return this.garcon;
    }

    public int getNum() {
        return this.num;
    }

    public Table getTable() { return this.table; }
}

