import java.util.ArrayList;

/**
 * Created by Syane on 18/06/2016.
 */
public class Menu {
    private ArrayList<Item> dishes = new ArrayList<Item>();
    private ArrayList<Item> beverages = new ArrayList<Item>();

    //Setters e Getters para os atributos de Menu
    public void setDishes(Item item){ this.dishes.add(item); }

    public void setBeverages(Item item){ this.beverages.add(item); }

    public ArrayList<Item> getDishes(){ return this.dishes; }

    public ArrayList<Item> getBeverages(){ return this.beverages; }

}
