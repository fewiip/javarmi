/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

/**
 *
 * @author felipe
 */
public class Resource2 {
    public Resource2() {

    } 

    ArrayList<InterfaceCli> listaPedidos =  new ArrayList<>();
    
    Boolean estaEmUso = false;
    int queries = 0;
    
    
    //indica um registro de interesse
    public int requestCS (InterfaceCli referenciaCliente) throws RemoteException {
        //esse sout ia sair no terminal do servidor 
        //System.out.println("pediu recurso");
        
        if (estaEmUso){
            listaPedidos.add(referenciaCliente);
            return 0;
        }
        if(listaPedidos.isEmpty()) {
            estaEmUso = true;
            listaPedidos.add(referenciaCliente);
            try {
                String mensagem = "Ja pode usar o recurso!";
                byte[]assinatura = Servidor.remetente.geraAssinatura(mensagem);
                listaPedidos.get(0).notificar(mensagem, assinatura);
                /*
                PublicKey publickey = Servidor.remetente.getPubKey();
                listaPedidos.get(0).notificar(mensagem, assinatura, publickey);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }
    
    public void exitCS() throws RemoteException {
        listaPedidos.remove(0);
        
        //terminou de usar o recurso
        if(listaPedidos.isEmpty()){
            estaEmUso = false;
        }else{
            //notifica o primeiro da lista 
            try {
                String mensagem = "Ja pode usar o recurso!";
                byte[]assinatura = Servidor.remetente.geraAssinatura(mensagem);
                listaPedidos.get(0).notificar(mensagem, assinatura);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
    
    public void query() throws RemoteException {
        queries++;
        try {
            String mensagem = "numero de queries realizadas: " + queries;
            byte[]assinatura = Servidor.remetente.geraAssinatura(mensagem);
            listaPedidos.get(0).notificar(mensagem, assinatura);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
