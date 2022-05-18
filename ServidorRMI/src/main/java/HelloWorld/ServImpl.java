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
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {
    ArrayList<InterfaceCli> listaClientes = new ArrayList<>();
    
    public ServImpl () throws RemoteException {}
    
    
    public void registrarInteresse(String texto, InterfaceCli referenciaCliente) throws RemoteException {
        System.out.println("texto recebido: " + texto);
        listaClientes.add(referenciaCliente);
        
        
        for (InterfaceCli cli : listaClientes) {
            cli.notificar("Test");
        }
    }
    
}
