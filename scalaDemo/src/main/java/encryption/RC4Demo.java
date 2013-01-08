/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package encryption;

import java.util.Arrays;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/01/08
 */
public class RC4Demo {
    public static void main(String[] args) throws Exception {
        byte[] plainData = "abc123".getBytes();
        byte[] key = "Key".getBytes();
        RC4 rc4 = new RC4(key);
        byte[] cipherData = rc4.encrypt(plainData);
        System.out.println("加密后: " + new String(cipherData));
        byte[] _plainData = rc4.decrypt(cipherData);
        System.out.println("解密后: " + new String(_plainData));

        System.out.println();
        testEncrypt();
    }

    public static void testEncrypt() throws Exception {
        byte[] key = "Key".getBytes();
        RC4Cipher rc4 = new RC4Cipher(key);
        byte[] plainData = "Plaintext".getBytes();
        byte[] cipherData = rc4.encrypt(plainData);
        byte[] expectedData = "bbf316e8 d940af0a d3".getBytes();
        System.out.println(Arrays.equals(expectedData, cipherData));
    }
//
//    public static void testDecrypt() throws Exception {
//        String key = "Key";
//        RC4Cipher rc4 = new RC4Cipher(key.getBytes());
//        String actual = A9Utility.bytesToHex(rc4.decrypt(A9Utility.hexToBytes("BBF316E8D940AF0AD3")));
//        String expected = A9Utility.bytesToHex("Plaintext".getBytes());
//        assertEquals("Result", actual, expected);
//    }
//}

    static class RC4Cipher {
        private int[] S;
        private int[] T;
        private int keylen;
        private static final String ALGORITHM = "RC4";

        public RC4Cipher(byte[] key) throws Exception {
            if (key.length < 1 || key.length > 256) {
                throw new Exception("key must be between 1 and 256 bytes");
            } else {
                keylen = key.length;
                S = new int[256];
                T = new int[256];
                for (int i = 0; i < 256; i++) {
                    S[i] = i;
                    T[i] = key[i % keylen];
                }
                int j = 0;
                for (int i = 0; i < 256; i++) {
                    j = (j + S[i] + T[i]) % 256;
                    S[i] ^= S[j];
                    S[j] ^= S[i];
                    S[i] ^= S[j];
                }
            }
        }

        public byte[] encrypt(byte[] plaintext) {
            byte[] ciphertext = new byte[plaintext.length];
            int i = 0, j = 0, k, t;
            for (int counter = 0; counter < plaintext.length; counter++) {
                i = (i + 1) % 256;
                j = (j + S[i]) % 256;
                S[i] ^= S[j];
                S[j] ^= S[i];
                S[i] ^= S[j];
                t = (S[i] + S[j]) % 256;
                k = S[t];
                ciphertext[counter] = (byte) (plaintext[counter] ^ k);
            }
            return ciphertext;
        }

        public byte[] decrypt(byte[] ciphertext) {
            return encrypt(ciphertext);
        }

        public String getAlgorithm() {
            return ALGORITHM;
        }
    }

    static class RC4 {
        private int[] S;
        private int[] T;
        private int keylen;

        public RC4(byte[] key) {
            if (key.length < 1 || key.length > 256) {
                throw new RuntimeException("key must be between 1 and 256 bytes");
            }
            keylen = key.length;
            S = new int[256];
            T = new int[256];
            for (int i = 0; i < 256; i++) {
                S[i] = i;
                T[i] = key[i % keylen];
            }
            int j = 0;
            for (int i = 0; i < 256; i++) {
                j = (j + S[i] + T[i]) % 256;
                S[i] ^= S[j];
                S[j] ^= S[i];
                S[i] ^= S[j];
            }
        }

        private byte[] ints2Bytes(int[] buf) {
            byte[] _buf = new byte[buf.length];
            for (int j = 0; j < buf.length; j++) {
                _buf[j] = (byte) buf[j];
            }
            return _buf;
        }

        private int[] bytes2Ints(byte[] buf) {
            int[] _buf = new int[buf.length];
            for (int i = 0; i < _buf.length; i++) {
                _buf[i] = buf[i];
            }
            return _buf;
        }


        public byte[] encrypt(byte[] plainData) {
            byte[] ciphertext = new byte[plainData.length];
            int i = 0, j = 0, k, t;
            for (int counter = 0; counter < plainData.length; counter++) {
                i = (i + 1) % 256;
                j = (j + S[i]) % 256;
                S[i] ^= S[j];
                S[j] ^= S[i];
                S[i] ^= S[j];
                t = (S[i] + S[j]) % 256;
                k = S[t];
                ciphertext[counter] = (byte) (plainData[counter] ^ k);
            }
            return ciphertext;

        }

        public byte[] decrypt(byte[] cipherData) {
            return encrypt(cipherData);
        }
    }
}