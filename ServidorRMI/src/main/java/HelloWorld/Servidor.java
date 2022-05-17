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

/**
 *
 * @author felipe
 */
public class Servidor {
    public static void main(String[] args) {
        
        //keyboard shortcut code tamplate
        try {
            //iniciara o servico de nomes 
            Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
            //LocateRegistry.createRegistry(1099);
            InterfaceServ referenciaServidor = new ServImpl();
            referenciaServicoNomes.rebind("HelloWorld", referenciaServidor);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
