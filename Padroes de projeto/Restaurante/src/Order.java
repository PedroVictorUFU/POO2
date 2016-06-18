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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Garcon getGarcon() {
        return garcon;
    }

    public void setGarcon(Garcon garcon) {
        this.garcon = garcon;
    }
}
