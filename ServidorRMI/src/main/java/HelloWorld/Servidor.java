/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.server.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

/**
 *
 * @author felipe
 */
public class Servidor {
    
    public static RemetenteAssiDig remetente;
    
    public static void main(String[] args) {
        
        //keyboard shortcut code tamplate
        try {
            
            remetente = new RemetenteAssiDig();
            //remetente.geraAssinatura("teste");
            
            //iniciara o servico de nomes 
            //LocateRegistry.createRegistry(1099);
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
            
            InterfaceServ referenciaServidor = new ServImpl();
            
            //void rebind(String name, Remote obj);
            //Usado pelo servidor pra registrar o nome e a referencia de um objeto remoto
            referenciaServicoNomes.rebind("servidor", referenciaServidor);
            
            /*
            InterfaceResource referenciaRecurso = new ServantResource();
            referenciaServicoNomes.rebind("resource", referenciaRecurso);
            
            InterfaceBanco referenciaBD = new ServantBanco();
            referenciaServicoNomes.rebind("banco", referenciaBD);*/
            
            //o programa fica rodando pra sempre mesmo não tendo um while(true)
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
