import java.util.ArrayList;

/**
 * Created by Syane on 16/06/2016.
 */
public class Kitchen implements Subject {

    private boolean sign = false;
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void notifyObserver(int num) {
        for(Observer o: observers){
            o.update(this,isSign(), num);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    //Muda o valor do Alarme
    public void readyOrder(Order order){
        this.changeSign(order);
    }

    public void changeSign(Order order){
        if(sign)
            this.sign = false;
        else
            this.sign = true;
        notifyGarcon(order);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    //Mandao aviso para o garcon de que o pedido da mesa em atendimento esta pronto
    public void notifyGarcon(Order order) {
        order.getGarcon().updateOrder(this,this.sign,order);
        this.setSign(false);
    }

    public boolean isSign() {
        return this.sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
