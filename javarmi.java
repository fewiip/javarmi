import java.rmi.*;
import java.net.*;

/*
Servidor + Servidor de nome + Cliente

De acordo a professora: 
Servidor + Servente do servidor + Cliente + Servente do cliente
+ Interface do Servidor + Interface do cliente
*/



public interface Interface_CriticalSection extends Remote {
    void requestCS () throws RemoteException;
    void exitCS () throws RemoteException;
} 

public class CriticalSection implements Interface_CriticalSection {
    public CriticalSection () {
        //construtor
    }

    public void requestCS() throws RemoteException {
        System.out.println("Tentando entrar na sessao critica");
    }

    public void exitCS() throws RemoteException{
        System.out.println("Saindo da sessao critica");
    }

} 

public class Servidor {
    public void run () {
        try {
            Interface_CriticalSection cs = new CriticalSection();
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

public class Cliente {
    public void run () {

    }
}

public class App {
    public static void main(String[] args) {

        //baseado nos parametros passados pelo terminal eu escolho se sou cliente ou servidor
    }
} 