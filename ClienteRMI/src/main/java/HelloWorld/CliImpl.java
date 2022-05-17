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
public class CliImpl extends UnicastRemoteObject implements InterfaceCli {
    
    public CliImpl () throws RemoteException {
        //recebe a referencia do servidor
        //e com essa referencia podera chamar o metodo registrar interesse do servidor
        //InterfaceServ referenciaServidor = new InterfaceServ();
        
        //referenciaServidor.registrarInteresse("Oi", this);
    }
    
    
    public void notificar(String texto) throws RemoteException{
        System.out.println("cliente imprimindo mensagem recebida: " + texto);
    }
}
