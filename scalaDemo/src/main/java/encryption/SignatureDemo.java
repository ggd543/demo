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
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
public class SignatureDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        //B给A发送的信息
        byte[] plain = "password".getBytes();
        System.out.println("原文："+ Arrays.toString(plain));

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);

        //A生成一个密钥对
        KeyPair aKeyPair = generator.generateKeyPair();
        //A把公钥公开
        PublicKey aPublicKey = aKeyPair.getPublic();
        //A自己保存好私钥
        PrivateKey aPrivateKey = aKeyPair.getPrivate();
        System.out.println("A的公钥："+aPublicKey);
        System.out.println("A的私钥："+aPrivateKey);

        //B生成的一个密钥对
        KeyPair bKeyPair = generator.generateKeyPair();
        //B的公钥
        PublicKey bPublicKey = bKeyPair.getPublic();
        //B的私钥
        PrivateKey bPrivateKey = bKeyPair.getPrivate();
        System.out.println("B的公钥："+aPublicKey);
        System.out.println("B的私钥："+aPrivateKey);

        //第一步B操作
        //加密
        Cipher cipher = Cipher.getInstance("RSA");
        //B用A的公钥把信息加密
        cipher.init(Cipher.ENCRYPT_MODE,aPublicKey);
        cipher.update(plain);
        byte[] result1 = cipher.doFinal();
        System.out.println("加密结果："+Arrays.toString(result1));

        //把原文做一个信息摘要
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        digest.update(plain);
        byte[] hash = digest.digest();

        //签名
        Signature signature = Signature.getInstance("SHA1withRSA");
        //B用自己的私钥对信息摘要签名
        signature.initSign(bPrivateKey);
        signature.update(hash);
        byte[] signByte = signature.sign();


        //B把签名结果signByte和加密结果result1一起发送给A

        //第二步A操作
        //A得到B发过来的信息后用自己的私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, aPrivateKey);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();
        System.out.println("解密结果："+Arrays.toString(result2));
        System.out.println("原文比较："+Arrays.equals(result2, plain));

        //把解密的结果进行信息摘要
        digest.reset();
        digest.update(result2);
        byte[] hash2 = digest.digest();

        //比较两次摘要的结果是否一致
        signature.initVerify(bPublicKey);
        signature.update(hash2);
        boolean b = signature.verify(signByte);
        System.out.println("验证签名结果:"+b);
    }
}
