import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/*
Servidor + Servidor de nome + Cliente

De acordo a professora: 
Servidor + Servente do servidor + Cliente + Servente do cliente
+ Interface do Servidor + Interface do cliente
*/

public class App {
    public static void main(String[] args) {
        String opcao = null;
        Scanner scan = new Scanner(System.in);
        int id; 
        Boolean boolCliente = false;

        System.out.println("Atividade 2 - Java RMI\nby Felipe Avelino\n\n===================================\n");
        
        while(true){
            System.out.println("Favor escolher uma das duas opcoes\n1: Cliente\n2: Servidor");
            opcao = scan.nextLine();
            if (opcao.equals("1")) {
                boolCliente = true;
                break;
            }else if (opcao.equals("2")){
                break;
            }
            System.out.println("Opcao invalida");
        }

        if (boolCliente == true) {
            while(true){
                System.out.println("Favor escolher um dos id's\n1, 2, 3 ou 4\n");
                opcao = scan.nextLine();
                id = Integer.parseInt(opcao);
                if (id > 0 && id <5) {
                    break;
                }
                System.out.println("Opcao invalida");
            }

            Client cliente = new Client(id);

            while (true) {

            }

        }else{

        }
    }
} 

//uma interface remota 
public interface Interface_Resource extends Remote {
      requestCS () throws RemoteException;
    void exitCS () throws RemoteException;
} 

public class Resource implements Interface_Resource {
    public Resource () {
        //construtor
    }

    public void requestCS() throws RemoteException {
        System.out.println("Tentando entrar na sessao critica");
    }

    public void exitCS() throws RemoteException{
        System.out.println("Saindo da sessao critica");
    }

} 

public interface Interface_Server {
    void registrarInteresse();
    void cancelarInteresse();
}

public class Server {
    public void run () {
        try {
            Interface_Resource cs = new Resource();
            String objName = "rmi://localhost/cs";

            //registrando o objeto no RMIRegistry
            //Vamos usar LocateRegistry
            LocateRegistry.createRegistry(1099);//porta padrao
            //rebind: 
            Naming.rebind(objName, cs);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

} 

//servente do servidor
public class ServImpl extends UnicastRemoteObject implements Interface_Server{
    public ServImpl() throws RemoteException {}
    
    void registrarInteresse();
}

public interface Interface_Client extends Remote {
    
    //nao pode usar o nome notify
    void notificar(String texto) throws RemoteException;
}  

public class Client {
    int id; 

    public Client (int id) {
        this.id = id;
    }

    public void run () throws Exception {
        String objName = "rmi://localhost:1099/cs";
        Interface_Resource resource = (Interface_Resource) Naming.lookup(objName);
        System.out.println("Client id: "+ this.id +" tentando usar o recurso!");
        resource.requestCS();
    }
}

