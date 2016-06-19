import java.util.ArrayList;

/**
 * Created by Syane on 16/06/2016.
 */

//No garcon é utilizado o Padrão de projeto Observer onde garcon é o Observador do Sujeito no caso Order e Mesa

public class Garcon extends Funcionario implements Observer {

    private int numGarcon;
    private String login;
    private String senha;
    private ArrayList<Table> table = new ArrayList<Table>();

    public Garcon(int numGarcon,int numFunc, String nome,String RG,String endereco,String telefone,String login, String senha){
        super(numFunc, nome, RG, endereco, telefone);
        this.numGarcon = numGarcon;
        this.senha = senha;
        this.login = login;

    }

    //Funcao do Observer quando recebe um chamado da mesa
    @Override
    public void update(Subject s,boolean sign, int num) {
        System.out.print("Garcon "+getNumGarcon()+ ": ");
        if(sign){
            System.out.println("[INFO] A mesa de numero: " +  num + " esta dando o alarme!!!\n");
        }
        else
            System.out.println("[INFO] A mesa de numero " + num + " ,acabou de ser atendida\n");
    }

    //Funcão que da informações sobre o  pedido para o garcon
    public void updateOrder(Subject s,Order order){
        System.out.println("Garçon: nº "+this.getNumGarcon()+" " + this.getNome());
        System.out.println("[INFO PEDIDO] O pedido da mesa: "+ order.getTable().getNum() +" esta " + order.getState().mostraEstado());
    }

    //Funcao que faz o garcon responder ao chamado da mesa
    public void asnwerTable(Table table){
        if(table.getGarcon() == null) {
            this.table.add(table);
            table.getAlarm().chageSign(table);
            table.setGarcon(this);
        }
        else{

            System.out.println("Atendimento da mesa feito pelo Garcon: " +table.getGarcon().getNumGarcon());
        }
    }

    //Funcao que faz o garcon enviar o pedido a cozinha
    public void sendOrder(Table table,Kitchen kitchen){
        kitchen.addOrder(table.getOrder());
    }

    //Funcao que cancela o Pedido na lista da cozinha
    public void cancelOrder(Table table, Kitchen kitchen) {
        if(table.getOrder().getState().getState() == "Em Espera")
        kitchen.removeOrder(table.getOrder());
        else
            System.out.println("[INFO COZINHA] O pedido não ser cancelado.");
    }

    //Funcao para add Item ao pedido
    public void makeOrder(Table table, Item item) { table.getOrder().getState().addItem(item); }

    //Fecha a conta da mesa
    public void fecharConta(Table table) {table.getOrder().getState().fechaConta();}

    //Retira item da mesa se possivel
    public void removeItemPedido(Table table, Item item) { table.getOrder().getState().retiraItem(item);}

    //Getters e Setters dos atributos contido na classe
    public void setNumGarcon(int numGarcon) {
        this.numGarcon = numGarcon;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) { this.login = login; }

    public int getNumGarcon() {
        return numGarcon;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() { return this.senha; }

}
