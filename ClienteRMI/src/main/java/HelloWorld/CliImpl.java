/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.security.PublicKey;
/**
 *
 * @author felipe
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli {
    InterfaceServ referenciaServidor = null;
    DestinatarioAssiDig assinaturaDigitalCliente = new DestinatarioAssiDig();
    private PublicKey pubKey;
    
    public CliImpl (InterfaceServ referenciaServidor) throws RemoteException {
        //recebe a referencia do servidor
        //e com essa referencia podera chamar o metodo registrar interesse do servidor
        this.referenciaServidor = referenciaServidor;
        //referenciaServidor.registrarInteresse("Oi", this);
    }
    
    public void setPubKey(PublicKey pubKey) {
        this.pubKey = pubKey;
    }
    
    //public void notificar(String mensagem, byte[]assinatura,PublicKey publickey) throws RemoteException{
    public void notificar(String mensagem, byte[]assinatura) throws RemoteException{    
        System.out.println("cliente imprimindo mensagem recebida: \"" + mensagem +"\"");
        int resultado = 0;
        try {
            //a chave publica já tá guardada
            resultado = assinaturaDigitalCliente.recebeMensagem(mensagem,assinatura,pubKey);
            if (resultado == 1) {//assim so desbloqueia se tiver validado
                synchronized (Cliente.lock) {
                    Cliente.lock.notify();
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
