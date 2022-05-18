/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ServantResource extends UnicastRemoteObject implements InterfaceResource {
    ArrayList<InterfaceCli> listaClientes = new ArrayList<>();
    Boolean estaEmUso = false;
    int queries = 0;
    
    
    public ServantResource() throws RemoteException{
    
    }
    
    public int requestCS (InterfaceCli referenciaCliente) throws RemoteException {
        //esse sout ia sair no terminal do servidor 
        //System.out.println("pediu recurso");
        if (estaEmUso){
            listaClientes.add(referenciaCliente);
            return 0;
        }
        if(listaClientes.isEmpty()) {
            estaEmUso = true;
            listaClientes.add(referenciaCliente);
            listaClientes.get(0).notificar("Ja pode usar o recurso!");
            //referenciaCliente.notificar("Ja pode usar o recurso!");
            return 1;
        }
        return 0;
    }
    
    public void exitCS() throws RemoteException {
        listaClientes.remove(0);
        
        //terminou de usar o recurso
        if(listaClientes.isEmpty()){
            estaEmUso = false;
        }else{
            //notifica o primeiro da lista ,
            listaClientes.get(0).notificar("Ja pode usar o recurso!");
        }
    }    
    
    public void query() throws RemoteException {
        queries++;
        listaClientes.get(0).notificar("Total de queries feitas: "+queries);
    }
}

