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

    public void changeState(Order order){
        order.getState().chageState();
        notifyGarcon(order);
    }

    public void addOrder(Order order) {
        order.setKitchen(this);
        this.orders.add(order);

    }

    public void removeOrder(Order order) { this.orders.remove(order); }

    //Mandao aviso para o garcon de que o pedido da mesa em atendimento esta pronto
    public void notifyGarcon(Order order) {
        order.getGarcon().updateOrder(this,order);
        //this.setSign(false);
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
