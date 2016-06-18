/**
 * Created by Syane on 16/06/2016.
 */
public class Main {

    public static void main(String [] args){

       /*
        Alarm alarm = new Alarm();
         */

        Table table1 = new Table(1,3);
        Table table2 = new Table(2,4);

        Kitchen kitchen = new Kitchen();

        /*
        Garcon(int numGarcon,int numFunc, String nome,String RG,String endereco,String telefone,String login, String senha)
         */
        Garcon garcon1 = new Garcon(1,1,"Mario Jorge Oliveira","145432345","Rua 15, 1560,Bairro X","3435-6677","MarioJ","garcon1");
        Garcon garcon2 = new Garcon(2,2,"Valeria Aparecida Nascimento","134565421","Rua 22, 678, Bairro X","3211-0066","ValeriaA","garcon2");
        Garcon garcon3 = new Garcon(3,3,"Hoo Lee sheet","456512343","Rua 30, 567,Bairro A","3456-7890","HooLee","garcon3");

        table1.getAlarm().addObserver(garcon1);
        table1.getAlarm().addObserver(garcon2);
        table1.getAlarm().addObserver(garcon3);

        table2.getAlarm().addObserver(garcon1);
        table2.getAlarm().addObserver(garcon2);
        table2.getAlarm().addObserver(garcon3);

        table1.callGarcon();
        table2.callGarcon();

        garcon2.asnwerTable(table2);
        garcon1.asnwerTable(table1);

        //Pedido pronto
      /*  kitchen.addOrder(table1.makeaOrder(1,table1.getGarcon()));
        System.out.print(table1.getOrder().getNum());
        kitchen.readyOrder(table1.getOrder());*/
    }
}
