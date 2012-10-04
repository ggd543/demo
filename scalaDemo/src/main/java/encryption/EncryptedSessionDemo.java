package encryption;

import javax.crypto.*;
import java.security.*;
import java.util.Arrays;

/**
 * User: 刘永健
 * Date: 12-10-4
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class EncryptedSessionDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        // B给A发送的信息
        byte[] plain = "password".getBytes();
        System.out.println("原文：" + Arrays.toString(plain));

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);

        // A生成一个密钥对
        KeyPair aKeyPair = generator.generateKeyPair();
        // A把公钥公开
        PublicKey aPublicKey = aKeyPair.getPublic();
        // A自己保存好私钥
        PrivateKey aPrivateKey = aKeyPair.getPrivate();
        System.out.println("A的公钥：" + aPublicKey);
        System.out.println("A的私钥：" + aPrivateKey);

        // B产生的会话密钥（对称的）
        KeyGenerator generator2 = KeyGenerator.getInstance("AES");
        SecretKey secretKey = generator2.generateKey();
        System.out.println("B的会话密钥:" + Arrays.toString(secretKey.getEncoded()));

        // B生成的一个密钥对
        KeyPair bKeyPair = generator.generateKeyPair();
        // B的公钥
        PublicKey bPublicKey = bKeyPair.getPublic();
        // B的私钥
        PrivateKey bPrivateKey = bKeyPair.getPrivate();
        System.out.println("B的公钥：" + aPublicKey);
        System.out.println("B的私钥：" + aPrivateKey);

        // 第一步B操作
        // 用B的会话密钥加密信息
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        cipher.update(plain);
        byte[] result1 = cipher.doFinal();
        System.out.println("加密结果：" + Arrays.toString(result1));

        // 用A的公钥对B的会话密钥secretKey进行加密
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, aPublicKey);
        rsaCipher.update(secretKey.getEncoded());
        byte[] sessionKeyEnc = rsaCipher.doFinal();
        System.out.println("加密B会话密钥：" + Arrays.toString(sessionKeyEnc));

        // 把原文做一个信息摘要
        MessageDigest digest = MessageDigest.getInstance("SHA1");
        digest.update(plain);
        byte[] hash = digest.digest();

        // 签名
        Signature signature = Signature.getInstance("SHA1withRSA");
        // B用自己的私钥对信息签名
        signature.initSign(bPrivateKey);
        signature.update(hash);
        byte[] signByte = signature.sign();

        // B把签名结果signByte和加密结果result1一起发送给A

        // 第二步A操作
        // A得到B发过来的会话密钥的加密结果用自己的私钥进行解密,加密会话密钥
        rsaCipher.init(Cipher.DECRYPT_MODE, aPrivateKey);
        rsaCipher.update(sessionKeyEnc);
        byte[] sessionKeyDec = rsaCipher.doFinal();

        SecretKey secretKey2 = new AESKey(secretKey.getAlgorithm(), secretKey.getFormat(), sessionKeyDec);
        System.out.println("解密B会话密钥：" + Arrays.toString(secretKey2.getEncoded()));
        // 用会话密钥解密加密信息
        cipher.init(Cipher.DECRYPT_MODE, secretKey2);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();

        System.out.println("解密结果：" + Arrays.toString(result2));
        System.out.println("原文比较：" + Arrays.equals(result2, plain));

        // 把解密的结果进行信息摘要
        digest.reset();
        digest.update(result2);
        byte[] hash2 = digest.digest();

        // 比较两次摘要的结果是否一致
        signature.initVerify(bPublicKey);
        signature.update(hash2);
        boolean b = signature.verify(signByte);
        System.out.println("验证签名结果:" + b);
    }
}
