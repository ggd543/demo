package encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Arrays;

/**
 * User: 刘永健
 * Date: 12-10-4
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */
public class RSADemo{
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //B给A发送的信息
        byte[] plain = "password".getBytes();
        System.out.println("原文："+ Arrays.toString(plain));

        //A生成一个密钥对
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(3072); // 指定密钥长度
        KeyPair keyPair = generator.generateKeyPair();

        //A把公钥公开
        PublicKey publicKey = keyPair.getPublic();
        //A自己保存好私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("公钥："+publicKey);
        System.out.println("私钥："+privateKey);

        Cipher cipher = Cipher.getInstance("RSA");
        //B用A的公钥把信息加密后发给A
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        cipher.update(plain);
        byte[] result1 = cipher.doFinal();
        System.out.println("加密结果："+Arrays.toString(result1));

        //A得到B发过来的信息后用自己的私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();
        System.out.println("解密结果："+Arrays.toString(result2));

        System.out.println("原文比较："+Arrays.equals(result2, plain));
    }
}
