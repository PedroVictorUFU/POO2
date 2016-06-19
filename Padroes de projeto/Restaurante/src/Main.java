/**
 * Created by Syane on 16/06/2016.
 */
public class Main {

    public static void main(String [] args){

        //Criação dos objetos Mesa e Cozinha
        Table table1 = new Table(1,3);
        Table table2 = new Table(2,4);

        Kitchen kitchen = new Kitchen();

        /*
        Garcon(int numGarcon,int numFunc, String nome,String RG,String endereco,String telefone,String login, String senha)
         */
        //Criando os objetos garcons
        Garcon garcon1 = new Garcon(1,1,"Mario Jorge Oliveira","145432345","Rua 15, 1560,Bairro X","3435-6677","MarioJ","garcon1");
        Garcon garcon2 = new Garcon(2,2,"Valeria Aparecida Nascimento","134565421","Rua 22, 678, Bairro X","3211-0066","ValeriaA","garcon2");
        Garcon garcon3 = new Garcon(3,3,"Hoo Lee sheet","456512343","Rua 30, 567,Bairro A","3456-7890","HooLee","garcon3");

        //Adcionando os garcons como observers da Mesa
        table1.getAlarm().addObserver(garcon1);
        table1.getAlarm().addObserver(garcon2);
        table1.getAlarm().addObserver(garcon3);

        table2.getAlarm().addObserver(garcon1);
        table2.getAlarm().addObserver(garcon2);
        table2.getAlarm().addObserver(garcon3);

        //for so para verificar se o pedido foi add a lista de pedidos da cozinha
        /*
        for (Order o: kitchen.getOrders()){
            System.out.println(o.getNum());
        }
        */

        //Teste do Menu
        Menu menu = new Menu();
        Item item1;
        Item item2;
        Item item3;
        Item item4;

        //public void Dish(String Nome, float preco)
        item1 = new Dish("Tigela de Brigadeiro",2.);
        item1 = new Ingrediente(item1,"Leite Condensado",3.);
        item1 = new Ingrediente(item1,"Po de chocolate",3.);

        item4 = new Dish("Porção de Arroz",4.);
        item4 = new Ingrediente(item4,"Cebola",0.5);
        item4 = new Ingrediente(item4,"Alho",0.5);

        // public Beverage(String nome, float preco)
        item2 = new Beverage("Suco",4.);
        item2 = new Ingrediente(item2,"Laranja",1.);
        item2 = new Ingrediente(item2,"Gelo",0);

        item3 = new IndustrializedBeverage("Soda 2 L",4.);

        menu.setDishes(item1);
        menu.setBeverages(item2);
        menu.setBeverages(item3);
        menu.setDishes(item4);

        System.out.println("----Menu---");
        System.out.println("\nPratos:");
        for (Item i: menu.getDishes()){
            System.out.println(i.getNome() + " Valor : " + i.getPreco());
        }

        System.out.println("\nBebidas:");
        for (Item i: menu.getBeverages()){
            System.out.println(i.getNome() + " Valor : " + i.getPreco());
        }

        System.out.println();
        //Fazendo com que a mesa chame todos os garcons para atendimento
        table1.callGarcon();
        System.out.println();
        table2.callGarcon();

        //Garcon faz o atendimento a Mesa
        System.out.println();
        garcon2.asnwerTable(table2);
        System.out.println();
        garcon1.asnwerTable(table2);
        System.out.println();
        garcon1.asnwerTable(table1);

        //Mesa faz Pedido
        table1.makeaOrder(1, table1.getGarcon());
        table2.makeaOrder(2,table2.getGarcon());
        //Garcon montando pedido da mesa 1
        table1.getGarcon().makeOrder(table1,item1);
        table1.getGarcon().makeOrder(table1,item2);
        //Garcon 2 montando pedido da mesa 2
        table2.getGarcon().makeOrder(table2,item4);
        table2.getGarcon().makeOrder(table2,item3);

        //Garcon da mesa envia pedido para cozinha
        table1.getGarcon().sendOrder(table1,kitchen);
        table2.getGarcon().sendOrder(table1,kitchen);

        //Cozinha muda os estados do pedido assim que começa a preparar.. ou quando esta pronto
        //Em preparo
        kitchen.changeState(table1.getOrder());
        System.out.println();
        kitchen.changeState(table2.getOrder());
        System.out.println();
        //Prontos
        kitchen.changeState(table1.getOrder());
        System.out.println();
        kitchen.changeState(table2.getOrder());
        System.out.println();

        //Fechando as contas da Mesa
        table1.getGarcon().fecharConta(table1);
        System.out.println();
        table2.getGarcon().fecharConta(table2);

        //Teste depois de fechado se podera fazer algum pedido
        System.out.println();
        table1.getGarcon().makeOrder(table1,item2);
    }
}
