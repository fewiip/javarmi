/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HelloWorld;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author felipe
 */
public interface InterfaceResource extends Remote {
    //void query() throws RemoteException;
    int requestCS (InterfaceCli referenciaCliente) throws RemoteException;
    void exitCS () throws RemoteException;
    void query() throws RemoteException;
}
