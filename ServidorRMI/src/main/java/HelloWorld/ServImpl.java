/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {


    private Resource1 resource1 = new Resource1();
    private Resource2 resource2 = new Resource2();
    
    public ServImpl () throws RemoteException {}
    
    public PublicKey getPublicKey() throws RemoteException {
        return Servidor.remetente.getPubKey();
    } 

    public int requestResource1(InterfaceCli referenciaCliente) throws RemoteException {
        return resource1.requestCS(referenciaCliente);
    }
    public void queryResource1() throws RemoteException {
        resource1.query();
    }

    public void exitResource1 () throws RemoteException {
        resource1.exitCS();
    }
    
    
    public int requestResource2(InterfaceCli referenciaCliente) throws RemoteException {
        return resource2.requestCS(referenciaCliente);
    }
    public void queryResource2() throws RemoteException {
        resource2.query();
    }
    public void exitResource2 () throws RemoteException {
        resource2.exitCS();
    }
}
