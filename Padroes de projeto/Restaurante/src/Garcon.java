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

    @Override
    public void update(Subject s,boolean sign, int num) {
        System.out.print("Garcon "+getNumGarcon()+ ": ");
        if(sign){
            System.out.println("[INFO] A mesa de numero: " +  num + " esta dando o alarme!!!\n");
        }
        else
            System.out.println("[INFO] A mesa de numero " + num + " ,acabou de ser atendida\n");
    }

    public void updateOrder(Subject s,boolean sign,Order order){
        System.out.println("[INFO COZINHA] O pedido da mesa: "+ order.getTable().getNum() +"está pronto!");
    }

    public int getNumGarcon() {
        return numGarcon;
    }

    public void setNumGarcon(int numGarcon) {
        this.numGarcon = numGarcon;
    }

    public void asnwerTable(Table table){
        this.table.add(table);
        table.getAlarm().chageSign(table);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void sendOrder(Table table,Kitchen kitchen,int num){
        kitchen.addOrder(table.makeaOrder(num,this));
    }
}
