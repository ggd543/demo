/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/01/08
 */
public class CipherDemo {
    private static final  String[] CIPHER_ALGORITHM={"AES", "DES", "TripleDes"};

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, UnsupportedEncodingException  {
        byte[] plainData1 =getPlainData();

        for(String algorithm: CIPHER_ALGORITHM){
            SecretKey secretKey =generateKey(algorithm);
            byte[] encryptedData = encryptData(plainData1, secretKey, algorithm);
            byte[ ] plainData2 = decryptData(encryptedData, secretKey, algorithm);
                System.out.println("Compare：" + Arrays.equals(plainData2, plainData1));
        }
    }

    private static byte[] getPlainData() throws UnsupportedEncodingException {
        String plainText = "abc123";
        byte[] plainData1 = plainText.getBytes("UTF-8");
        System.out.println("Original text：" + Arrays.toString(plainData1));
        return plainData1;
    }

    private static SecretKey generateKey(String algorithm) throws NoSuchAlgorithmException {
        //Generate DES Key
        SecureRandom sr = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        generator.init(sr);
        SecretKey secretKey = generator.generateKey();
        System.out.println("Secret key: " + secretKey);
        System.out.println("The length of key: "+secretKey.getEncoded().length);
        System.out.println("The format of key: "+secretKey.getFormat());
        System.out.println("The algorithm of key: "+secretKey.getAlgorithm());
        return secretKey;
    }

    /**
     * Encrypt
     * @param plainData1
     * @param secretKey
     * @param algorithm
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    private static byte [] encryptData(byte[] plainData1, SecretKey secretKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new SecureRandom());
        cipher.update(plainData1);
        byte[] encryptedData = cipher.doFinal();
        System.out.println("The result of encrypted data：" + Arrays.toString(encryptedData));
        return encryptedData;
    }

    private static byte[] decryptData(byte[] encryptedData, SecretKey secretKey, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new SecureRandom());
        cipher.update(encryptedData);
        byte[] plainData2 = cipher.doFinal();
        System.out.println("The decrypted result：" + Arrays.toString(plainData2));
        return plainData2;
    }
}
