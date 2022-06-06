/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HelloWorld;

import java.rmi.*;
import java.net.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
/**
 *
 * @author felipe
 */
public interface InterfaceServ extends Remote {
    //void registrarInteresse(String texto, InterfaceCli referenciaCliente) throws RemoteException;
    PublicKey getPublicKey()throws RemoteException;

    public int requestResource1(InterfaceCli referenciaCliente) throws RemoteException;
    public void exitResource1 () throws RemoteException;
    public void queryResource1() throws RemoteException;
    
    //public int requestResource(int );

    public int requestResource2(InterfaceCli referenciaCliente) throws RemoteException;
    public void exitResource2 () throws RemoteException;
    public void queryResource2() throws RemoteException;
}
