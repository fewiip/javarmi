/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
/**
 *
 * @author felipe
 */
public class Cliente {
    static Object lock = new Object();
    static Boolean timerAcabou = false; 

    
    public static void main(String[] args) {
        
        String maquinaServidor = "rmi://localhost/";
        int portaServicoNomes = 1099;
        PublicKey pubKey;
        
        
        
        try {
            
            Registry referenciaServicoNomes = LocateRegistry.getRegistry();
            //Registry referenciaServicoNomes = LocateRegistry.getRegistry(maquinaServidor, portaServicoNomes);
            //Obterá a referência do servidor, consultando o SN
            
            /*referencia de objeto remota 
            identificacao pra um objeto, a gente so consegue invocar os metodos de um objeto remoto
            se a gente tiver essa referencia
            Qual eh o tipo dessa referencia? Eh a interface remota correspondente 
            */
            
            //Remote lookup(String name)
            //Usado pelos clientes para buscar uma referencia de objeto remoto
            //Servente eh a classe que implementa a interface
            InterfaceServ referenciaServidor = (InterfaceServ) referenciaServicoNomes.lookup("servidor");
            /*InterfaceResource referenciaRecurso = (InterfaceResource) referenciaServicoNomes.lookup("resource");
            InterfaceBanco referenciaBanco = (InterfaceBanco) referenciaServicoNomes.lookup("banco");*/
            CliImpl serventeCliente = new CliImpl(referenciaServidor);

            String opcao = null;
            Scanner scan = new Scanner(System.in);
            
            //primeira mensagem
            PublicKey publicKey = referenciaServidor.getPublicKey();
            serventeCliente.setPubKey(publicKey);//guarda a chave 

            System.out.println("Chave publica do servidor:\n" + publicKey);


            int banco = 0;

            //o programa ja ficaria rodando pra sempre mesmo não tendo um while(true)                            
            while(true) {
                banco = 0;
                while(true){
                        System.out.println("1: Entrar no Banco MySQL\n2. Entrar no MongoDB");
                        opcao = scan.nextLine();
                        if (opcao.equals("1") || opcao.equals("2")) {
                            break;
                        }
                        System.out.println("Opcao invalida");
                }
                
                /*
                fazendo assim nao foi 
                referenciaRecurso.requestCS(serventeCliente);
                sendo, void requestCS(InterfaceCli referenciaCliente);
                
                synchronized (lock) {
                    System.out.println("Entrou no lock!");
                    lock.wait();
                    System.out.println("saiu do lock!");
                }
                */
                
                int estado;
                //so consegui fazendo assim
                //message = referenciaRecurso.requestCS(serventeCliente);
                if (opcao.equals("1")){
                    banco = 1;
                    estado = referenciaServidor.requestResource1(serventeCliente);
                    //estado = referenciaRecurso.requestCS(serventeCliente);
                }else{
                    banco = 2;
                    estado = referenciaServidor.requestResource2(serventeCliente);
                    //estado = referenciaBanco.requestCS(serventeCliente);
                }
                
                if (estado == 0){
                    synchronized (lock) {
                        lock.wait();
                        System.out.println("saiu do lock!");
                    }
                }
                
                if (banco == 1) {
                    referenciaServidor.queryResource1();
                    //referenciaRecurso.query();    
                } else {
                    referenciaServidor.queryResource2();
                    //referenciaBanco.query();
                }

                while(true){
                    System.out.println("1: Sair da seção critica");
                    opcao = scan.nextLine();
                    if (opcao.equals("1")) {
                            break;
                    }
                    System.out.println("Opcao invalida");
                }

                if (banco == 1) {
                    referenciaServidor.exitResource1();
                    //referenciaRecurso.exitCS();    
                } else {
                    referenciaServidor.exitResource2();
                    //referenciaBanco.exitCS();
                }
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

