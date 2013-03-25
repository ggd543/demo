package encryption;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RC4CipherTests {

    @Test
    public void testEncrypt() throws Exception {
        String key = "Key";
        RC4Cipher rc4 = new RC4Cipher(key.getBytes());
        byte[] plainData = "Plaintext".getBytes();
        byte[] cipherData = rc4.encrypt(plainData);
        String actual = A9Utility.bytesToHex(cipherData);
        String expected = "bbf316e8 d940af0a d3";
        byte[] expectedData = expected.getBytes();
        assertEquals("Result", actual, expected);
        assertArrayEquals(expectedData, cipherData);
    }

    @Test
    public void testDecrypt() throws Exception {
        String key = "Key";
        RC4Cipher rc4 = new RC4Cipher(key.getBytes());
        String actual = A9Utility.bytesToHex(rc4.decrypt(A9Utility.hexToBytes("BBF316E8D940AF0AD3")));
        String expected = A9Utility.bytesToHex("Plaintext".getBytes());
        assertEquals("Result", actual, expected);
    }

}
