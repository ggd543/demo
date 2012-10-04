package encryption;

import javax.crypto.SecretKey;

/**
 * User: 刘永健
 * Date: 12-10-4
 * Time: 下午9:42
 * To change this template use File | Settings | File Templates.
 */
public class AESKey implements SecretKey {

    private String alg;
    private String format;
    private byte[] encode;

    public AESKey(String alg, String format, byte[] encode) {
        this.alg = alg;
        this.format = format;
        this.encode = encode;
    }

    @Override
    public String getAlgorithm() {
        return alg;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public byte[] getEncoded() {
        return encode;
    }

}
