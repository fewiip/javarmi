/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelloWorld;

/**
 *
 * @author felipe
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;


public class DestinatarioAssiDig {

    //resultado = assinaturaDigitalCliente.recebeMensagem(pubKey, texto, assinatura);
    //public int recebeMensagem(Keychain keys) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    public int recebeMensagem(String mensagem, byte[]assinatura, PublicKey pubKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
   
        //public int recebeMensagem(String mensagem, byte[] assinatura, PublicKey pubKey) throws
        Signature clientSig = Signature.getInstance("DSA");
        clientSig.initVerify(pubKey);
        clientSig.update(mensagem.getBytes());

        //System.out.println("chave publica: "+pubKey+"\nmensagem: "+mensagem+"\nassinatura: "+assinatura);

        if (clientSig.verify(assinatura)) {
            //Mensagem corretamente assinada
            System.out.println("A Mensagem recebida foi assinada corretamente.");
            return 1;
        } else {
            //Mensagem não pode ser validada
            System.out.println("A Mensagem recebida NÃO pode ser validada.");
            return 0;
        }
   }

}