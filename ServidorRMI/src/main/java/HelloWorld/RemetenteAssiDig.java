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
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

/**
 *
 * @author elder fonte: https://www.devmedia.com.br/como-criar-uma-assinatura-digital-em-java/31287
 */
public class RemetenteAssiDig {

    private PublicKey pubKey;
    private PrivateKey priKey;
    private Signature sig; 

    public RemetenteAssiDig () throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        sig = Signature.getInstance("DSA");

        //Geração das chaves públicas e privadas
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        SecureRandom secRan = new SecureRandom();
        kpg.initialize(512, secRan);
        KeyPair keyP = kpg.generateKeyPair();
        this.pubKey = keyP.getPublic();
        priKey = keyP.getPrivate();

        //Inicializando Obj Signature com a Chave Privada
        sig.initSign(priKey);
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public void setPubKey(PublicKey pubKey) {
        this.pubKey = pubKey;
    }


    public byte[] geraAssinatura(String mensagem) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        //Gerar assinatura
        sig.update(mensagem.getBytes());
        byte[] assinatura = sig.sign();

        return assinatura;
    }

}