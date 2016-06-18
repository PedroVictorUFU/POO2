import java.util.ArrayList;

/**
 * Created by Syane on 16/06/2016.
 */

//No alarm é utilizado o Subject do padrão de projeto Observer e o Alarme ele pertence a Mesa
public class Alarm implements Subject {

    private boolean sign = false;
    private ArrayList<Observer>observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer o) {
       observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }


    public void notifyGarcon(Garcon g,int num){
            g.update(this,isSign(),num);
    }

    @Override
    public void notifyObserver(int num) {
        for(Observer o: observers){
            o.update(this,isSign(), num);
        }
    }

    public void chageSign(Table table){
        if(sign)
            sign = false;
        else
            sign = true;
        notifyObserver(table.getNum());
    }

    //Getters e Setters dos atributos da classe
    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public void setObservers(ArrayList<Observer> observers) {
        observers = observers;
    }

    public ArrayList<Observer> getObservers() {
        return this.observers;
    }

    public boolean isSign() {
        return this.sign;
    }
}
