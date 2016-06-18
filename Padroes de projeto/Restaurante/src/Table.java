/**
 * Created by Syane on 16/06/2016.
 */
public class Table {

    private int num;
    private int numChair;
    private Garcon garcon;
    private Alarm alarm = new Alarm();
    private Order order;

    public Table( int num, int numChair){
        this.num = num;
        this.numChair = numChair;
    }

    public void callGarcon(){
        if(garcon == null) {
            this.alarm = alarm;
            alarm.chageSign(this);
        }
        else
            alarm.notifyGarcon(this.garcon,this.num);
    }


    //Fazendo pedido na mesa
    public Order makeaOrder(int num, Garcon garcon){
        this.order = new Order(num,this,garcon);
        return this.order;
    }

    //Getters e Setter dos atributos da classe
    public void setGarcon(Garcon garcon) {
        this.garcon = garcon;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    public Order getOrder(){
        return this.order;
    }

    public Garcon getGarcon() {
        return this.garcon;
    }

    public Alarm getAlarm() {
        return this.alarm;
    }

    public int getNum() {
        return this.num;
    }

}
