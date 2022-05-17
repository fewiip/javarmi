/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author felipe
 */
public class Cliente {
    public static void main(String[] args) {
        String maquinaServidor = "rmi://localhost/";
        int portaServicoNomes = 1099;
        
        try {
            Registry referenciaServicoNomes = LocateRegistry.getRegistry(maquinaServidor, portaServicoNomes);
        } catch(Exception e){e.printStackTrace();}
        
    }
}
