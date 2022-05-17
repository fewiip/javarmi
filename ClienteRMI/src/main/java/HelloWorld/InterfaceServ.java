/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HelloWorld;

import java.rmi.*;
import java.net.*;
/**
 *
 * @author felipe
 */
public interface InterfaceServ extends Remote {
    public void registrarInteresse(String texto, InterfaceCli referenciaCliente) throws RemoteException;
}
