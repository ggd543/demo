package encryption;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * User: 刘永健
 * Date: 12-10-4
 * Time: 下午8:56
 * To change this template use File | Settings | File Templates.
 */
public class AESDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] plain = "password".getBytes();
        System.out.println("原文："+ Arrays.toString(plain));

        //生成AES Key
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        SecretKey aesKey = generator.generateKey();

        //获取AES的Cipher
        Cipher cipher = Cipher.getInstance("AES");
        //初始化模式  加密
        cipher.init(Cipher.ENCRYPT_MODE,aesKey);
        cipher.update(plain);
        byte[] result1 = cipher.doFinal();
        System.out.println("加密结果："+Arrays.toString(result1));

        //解密
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        cipher.update(result1);
        byte[] result2 = cipher.doFinal();

        System.out.println("解密结果："+Arrays.toString(result2));
        System.out.println("原文比较："+Arrays.equals(result2, plain));
    }
}
