/**
 * Created by Syane on 16/06/2016.
 */
public interface Subject {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver(int num);

}
