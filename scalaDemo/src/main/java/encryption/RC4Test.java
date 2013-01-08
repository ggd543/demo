/*
* Copyright (C) 2003 Clarence Ho (clarence@clarenceho.net)
* All rights reserved.
*
* Redistribution and use of this software for non-profit, educational,
* or persoanl purposes, in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
* 1. Redistributions of source code must retain the above copyright
*    notice, this list of conditions and the following disclaimer.
* 2. Redistributions in binary form must reproduce the above copyright
*    notice, this list of conditions and the following disclaimer in the
*    documentation and/or other materials provided with the distribution.
* 3. Neither the name of the author nor the names of its contributors
*    may be used to endorse or promote products derived from this software
*    without specific prior written permission.
*
* In case of using this software for other purposes not stated above,
* please conact Clarence Ho (clarence@clarenceho.net) for permission.
*
* THIS SOFTWARE IS PROVIDED BY CLARENCE HO "AS IS"
* AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
* PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR
* OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
* SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
* LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
* USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
* AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
* LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
* IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
* THE POSSIBILITY OF SUCH DAMAGE.
*/
package encryption;

import java.security.Key;
import java.security.Security;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;

/**
* This class tests the RC4 implementation of net.clarenceho.crypto.RC4 against
* the implementation from Cryptix.  To run this test, you will need to install
* the Cryptix JCE library first.  For details of the Cryptix JCE library,
* please visit http://www.cryptix.org/products/jce/index.html
* <p/>
*
* @author Clarence Ho
*/
public class RC4Test {

    private static final Random rand = new Random();

    public RC4Test() {
//        try {
//            Security.addProvider(new cryptix.jce.provider.CryptixCrypto());
//        } catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
    }


    /**
     * Executes 2 tests.  The first test is to compare the ciphertext output
     * from both net.clarenceho.crypto.RC4 and Cryptix.
     * <br>
     * The second test is to decrypt the ciphertext
     * using net.clarenceho.crypto.RC4 and compare it with
     * the original plaintext.
     */
    public boolean test(byte[] key, byte[] data) {
        try {
            // uses net.clarenceho.crypto.RC4
            RC4 ownRc4 = new RC4(key);
            byte[] result_own = ownRc4.rc4(data);

            // uses cryptix
            Cipher c = Cipher.getInstance("RC4", "CryptixCrypto");
            c.init(Cipher.ENCRYPT_MODE, new K("RC4", key));
            byte[] result_cryptix = c.doFinal(data);

            // compares two ciphertexts
            if (!Arrays.equals(result_own, result_cryptix)) {
                return false;
            }

            // uses net.clarenceho.crypto.RC4 to decrypt
            ownRc4 = new RC4(key);
            byte[] result_own2 = ownRc4.rc4(result_own);

            if (!Arrays.equals(result_own2, data)) {
                return false;
            }

            return true;

        } catch (Exception e) {
            System.err.println("");
            e.printStackTrace(System.err);
            return false;
        }
    }

    private static boolean genRandomTest() {

        int keylength = rand.nextInt(15) + 1;
        byte key[] = new byte[keylength];
        for (int i = 0; i < keylength; i++) {
            key[i] = (byte) rand.nextInt(256);
        }

        int datalength = rand.nextInt(1500) + 1;
        byte data[] = new byte[datalength];
        for (int i = 0; i < datalength; i++) {
            data[i] = (byte) rand.nextInt(256);
        }

        System.out.print("key length=" + keylength + ";\tdata length=" + datalength);
        RC4Test test = new RC4Test();
        if (!test.test(key, data)) {
            System.out.println("    \tFailed");
            System.out.println("Problem: key=[" + dumpArray(key) + "]; data=[" + dumpArray(data) + "]");
            return false;
        } else {
            System.out.println("    \tOK");
            return true;
        }
    }

    private void benchmark() {
        try {
            int keylength = 16;
            byte key[] = new byte[keylength];
            for (int i = 0; i < keylength; i++) {
                key[i] = (byte) rand.nextInt(256);
            }

            int datalengthMB = 10;
            int datalength = 1024 * 1024 * datalengthMB;
            byte data[] = new byte[datalength];
            for (int i = 0; i < datalength; i++) {
                data[i] = (byte) rand.nextInt(256);
            }

            long start = System.currentTimeMillis();
            RC4 rc4 = new RC4(key);
            rc4.rc4(data);
            long end = System.currentTimeMillis();

            System.err.println("net.clarenceho.crypto.RC4:");
            System.err.println("Time taken to encrypt/decrypt " + datalengthMB + " MB: " + (end - start) + "ms");
            System.err.println("Speed: " + ((double) 1000.0 * datalengthMB / (end - start)) + " MB/s");
            System.err.println("");

            // uses cryptix
            start = System.currentTimeMillis();
            Cipher c = Cipher.getInstance("RC4", "CryptixCrypto");
            c.init(Cipher.ENCRYPT_MODE, new K("RC4", key));
            byte[] result_cryptix = c.doFinal(data);
            end = System.currentTimeMillis();

            System.err.println("Cryptix:");
            System.err.println("Time taken to encrypt/decrypt " + datalengthMB + " MB: " + (end - start) + "ms");
            System.err.println("Speed: " + ((double) 1000.0 * datalengthMB / (end - start)) + " MB/s");

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }


    private static String dumpArray(byte[] buf) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buf.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }

            sb.append(Integer.toString((buf[i] & 0xff) + 0x100, 16).substring(1).toUpperCase());
        }

        return sb.toString();
    }


    public static void main(String args[]) {

        System.out.println("Compare ciphertext output between this class and Crypix's implementation...");
        for (int i = 0; i < 1000; i++) {
            if (!genRandomTest()) {
                return;
            }
        }

        System.out.println("");

        System.out.println("Benchmarking...");
        RC4Test test = new RC4Test();
        test.benchmark();
    }


    /**
     * This is a Key class from the Cryptix library.  The following
     * is the license statement from Cryptix source file:
     * <p/>
     * <pre>
     * Copyright (C) 1995-2000 The Cryptix Foundation Limited.
     * All rights reserved.
     *
     * Use, modification, copying and distribution of this software is subject
     * the terms and conditions of the Cryptix General Licence. You should have
     * received a copy of the Cryptix General Licence along with this library;
     * if not, you can download a copy from http://www.cryptix.org/ .
     * </pre>
     */
    private class K implements Key {
        private final byte[] keyBytes;
        private final String alg;

        K(String alg, byte[] keyBytes) {
            this.alg = alg;
            this.keyBytes = keyBytes;
        }

        public String getAlgorithm() {
            return alg;
        }

        public String getFormat() {
            return "RAW";
        }

        public byte[] getEncoded() {
            return (byte[]) keyBytes.clone();
        }
    }


}