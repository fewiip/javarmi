import java.rmi.*;
import java.rmi.server.RemoteObject;


/*
public interface ICalculadora extends Remote {
    int adicao(int x, int y) throws RemoteException;
public interface Recurso1 extends Remote {
    void entrarSessaoCritica () throws RemoteException;
} 

public interface Recurso2 extends Remote {
    void entrarSessaoCritica() throws RemoteException;

}
}*/

//LocateRegistry

public interface Interface_CriticalSection extends Remote {
    void requestCS () throws RemoteException;
    void exitCS () throws RemoteException;
} 

public class CriticalSection implements Interface_CriticalSection {
    public CriticalSection () {

    }

    public void requestCS() throws RemoteException {

    }

    public void exitCS() throws RemoteException{
        
    }

} 

public class Servidor {


} 

public class Cliente {

}

public class App {
    public static void main(String[] args) {
        
    }
} 