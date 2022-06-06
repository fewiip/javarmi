/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HelloWorld;

import java.rmi.*;
import java.net.*;

import java.security.PublicKey;
/**
 *
 * @author felipe
 */
public interface InterfaceCli extends Remote {
    void notificar(String texto, byte[]assinatura) throws RemoteException;
    //void notificar(String texto, byte[]assinatura, PublicKey publickey) throws RemoteException;
    //void notificar(Keychain keys) throws RemoteException;
    void setPubKey(PublicKey pubKey) throws RemoteException;
}
