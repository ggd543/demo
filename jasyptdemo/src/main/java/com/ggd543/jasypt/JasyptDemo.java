/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-18
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
package com.ggd543.jasypt;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jasypt.commons.CommonUtils;
import org.jasypt.util.digest.Digester;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class JasyptDemo {
    private static void passwordEncryptionAndDecryption() {
        //加密
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("password");
        String newPassword = textEncryptor.encrypt("123456");
        System.out.println(newPassword);
//        解密
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
        textEncryptor2.setPassword("password");
        String oldPassword = textEncryptor2.decrypt(newPassword);
        System.out.println(oldPassword);
    }

    private static void strongTextEncryptionAndDecryption() {
        /**
         * Utility class for easily performing high-strength encryption of texts.
         *	This class internally holds a StandardPBEStringEncryptor configured this way:
         *	Algorithm: PBEWithMD5AndTripleDES.
         *	Key obtention iterations: 1000.
         *	The required steps to use it are:
         *	Create an instance (using new).
         *	Set a password (using setPassword(String)).
         *	Perform the desired encrypt(String) or decrypt(String) operations.
         *	To use this class, you may need to download and install the Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files.
         *	This class is thread-safe.
         */
        StrongTextEncryptor ste = new StrongTextEncryptor();
        //加密
        ste.setPassword("password");
        String encyptedResult = ste.encrypt("123456");
        System.out.println("encyptedResult:" + encyptedResult);
        //解密
        String dencyptedResult = ste.decrypt(encyptedResult);
        System.out.println(dencyptedResult);

    }

    private static void testJasyptDigester(String algorithm) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("hello.txt");
        if (is != null) {
            try {
                byte[] message = IOUtils.toByteArray(is);
                Digester digester = new Digester();
                digester.setAlgorithm(algorithm);
                byte[] digest = digester.digest(message);
                System.out.println(Arrays.toString(digest));
                System.out.println(algorithm);
                System.out.println(digest.length);
                System.out.println("digest:"+ CommonUtils.toHexadecimal(digest));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
                IOUtils.closeQuietly(is);
            }
        }

    }

    public static String bytes2Hex(byte[] bts) {
        StringBuffer des = new StringBuffer();
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des.append("0");
            }
            des.append(tmp);
        }
        return des.toString();
    }

    public static void main(String[] args) {
        passwordEncryptionAndDecryption();
        testJasyptDigester("MD5");
        testJasyptDigester("SHA-1");
        testJasyptDigester("SHA-256");
        testJasyptDigester("SHA-384");
        testJasyptDigester("SHA-512");

    }
}
