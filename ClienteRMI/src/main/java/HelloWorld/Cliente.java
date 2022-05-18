/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

/**
 *
 * @author felipe
 */
public class Cliente {
    static Object lock = new Object();
    static int podeusar = 0;
    
    public static void main(String[] args) {
        String maquinaServidor = "rmi://localhost/";
        int portaServicoNomes = 1099;
        
        
        try {
            Registry referenciaServicoNomes = LocateRegistry.getRegistry();
            //Registry referenciaServicoNomes = LocateRegistry.getRegistry(maquinaServidor, portaServicoNomes);
            //Obteráareferênciadoservidor,consultandooSN
            
            /*referencia de objeto remota 
            identificacao pra um objeto, a gente so consegue invocar os metodos de um objeto remoto
            se a gente tiver essa referencia
            Qual eh o tipo dessa referencia? Eh a interface remota correspondente 
            */
            
            //Remote lookup(String name)
            //Usado pelos clientes para buscar uma referencia de objeto remoto
            //Servente eh a classe que implementa a interface
            InterfaceServ referenciaServidor = (InterfaceServ) referenciaServicoNomes.lookup("servidor");
            CliImpl serventeCliente = new CliImpl(referenciaServidor);
            
            //o programa ja ficaria rodando pra sempre mesmo não tendo um while(true)
            
            InterfaceResource referenciaRecurso = (InterfaceResource) referenciaServicoNomes.lookup("resource");
            
            
            String opcao = null;
            Scanner scan = new Scanner(System.in);
                                        
            while(true) {
                while(true){
                        System.out.println("1: Entrar da seção critica");
                        opcao = scan.nextLine();
                        if (opcao.equals("1")) {
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
                
                //so consegui fazendo assim
                int estado = referenciaRecurso.requestCS(serventeCliente);
                
                if (estado == 0){
                    synchronized (lock) {
                        //System.out.println("Entrou no lock!");
                        lock.wait();
                        //System.out.println("saiu do lock!");
                    }
                }
                
                referenciaRecurso.query();
                
                while(true){
                    System.out.println("1: Sair da seção critica");
                    opcao = scan.nextLine();
                    if (opcao.equals("1")) {
                            break;
                    }
                    System.out.println("Opcao invalida");
                }
                referenciaRecurso.exitCS();
                podeusar = 0;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

final class CallBacksThread implements Runnable {
    public CallBacksThread () {
        Thread t = new Thread(this);
        t.start();
    }
    
    public void run () {
        try {
            
        } catch (Exception e) {
        }
    }
    
}