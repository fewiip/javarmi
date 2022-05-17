/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author felipe
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {
    
    public ServImpl () throws RemoteException {}
    
    
    public void registrarInteresse(String texto, InterfaceCli referenciaCliente) throws RemoteException {
        System.out.println("teste");
    }
    
}
