package enumeration;

/**
 * User: 刘永健
 * Date: 12-10-4
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */

import sun.security.pkcs11.wrapper.CK_MECHANISM;

enum KeyAlg {
    // 枚举常量放在第一行
    SM2("SM3withSM2"), RSA("SHA1withRSA");

    public final int keySize;
    public final String signName;
    public final CK_MECHANISM mechanism;
    public final CK_MECHANISM signMechanism;
    public final boolean isSM2;

    // 枚举的构造必须是私有的
    private KeyAlg(String signName) {
        this.signName = signName;
        if (name().equals("SM2")) {
            keySize = 256;
            mechanism = new CK_MECHANISM(0x80008201L);
            signMechanism = new CK_MECHANISM(0x80008101L);
            isSM2 = true;
        } else {
            keySize = 1024;
            mechanism = new CK_MECHANISM(0x80008201L);
            signMechanism = new CK_MECHANISM(0x1L);
            isSM2 = false;
        }
    }

    // 空构造是默认的
    private KeyAlg() {
        keySize = -1;
        signName = null;
        mechanism = null;
        signMechanism = null;
        isSM2 = false;
    }
}

public class EnumTest {
    static KeyAlg keyAlg = KeyAlg.RSA;

    public static void main(String[] args) {
        // 枚举常量的名
        System.out.println(keyAlg.name());
        // 该常量在枚举中的位置
        System.out.println(keyAlg.ordinal());
        // 通过name得到枚举常量
        System.out.println(KeyAlg.valueOf("SM2").name());
    }
}

