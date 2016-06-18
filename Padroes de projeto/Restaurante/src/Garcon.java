import java.util.ArrayList;

/**
 * Created by Syane on 16/06/2016.
 */

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

    //Funcão que aciona o garcon quando o pedido esta pronto
    public void updateOrder(Subject s,boolean sign,Order order){
        System.out.println("Garçon: nº "+this.getNumGarcon()+" " + this.getNome());
        System.out.println("[INFO COZINHA] O pedido da mesa: "+ order.getTable().getNum() +" está pronto!");
    }

    //Funcao que faz o garcon responder ao chamado da mesa
    public void asnwerTable(Table table){
        this.table.add(table);
        table.getAlarm().chageSign(table);
        table.setGarcon(this);
    }

    //Funcao que faz o garcon fazer um pedido para a mesa e enviar a cozinha
    public void sendOrder(Table table,Kitchen kitchen,int num){
        kitchen.addOrder(table.makeaOrder(num,this));
    }

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
