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
public class DESDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, UnsupportedEncodingException {
        String plainText = "abc123";
        byte[] plainData1 = plainText.getBytes("UTF-8");
        System.out.println("Original text：" + Arrays.toString(plainData1));

        //Generate DES Key
        SecureRandom sr = new SecureRandom();
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(sr);
        SecretKey secretKey = generator.generateKey();
        System.out.println("Secret key: " + secretKey);

        //Obtain a cipher of DES algorithm
        Cipher cipher = Cipher.getInstance("DES");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
        cipher.update(plainData1);
        byte[] encryptedData = cipher.doFinal();

        System.out.println("The result of encrypted data：" + Arrays.toString(encryptedData));

        //Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
        cipher.update(encryptedData);
        byte[] plainData2 = cipher.doFinal();

        System.out.println("The decrypted result：" + Arrays.toString(plainData2));
        System.out.println("Compare：" + Arrays.equals(plainData2, plainData1));
    }

}
