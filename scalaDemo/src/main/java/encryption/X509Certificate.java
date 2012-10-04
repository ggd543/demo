//package encryption;
//
//import sun.security.x509.X500Name;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.security.PublicKey;
//import java.security.cert.CertificateFactory;
//import java.util.Date;
//
///**
// * User: 刘永健
// * Date: 12-10-4
// * Time: 下午9:47
// * To change this template use File | Settings | File Templates.
// */
//public class X509Certificate {
//    public static X509Certificate getCertificate(PublicKey publicKey, X500Name subject) throws Exception {
//
//        //公钥算法OID
//        String sAlg = null;
//        //TODO 仅对RSA
//        sAlg = X509Util.getAlgorithmOID("SHA1with" + publicKey.getAlgorithm()).toString();
//        byte[] publicKeyEncode = publicKey.getEncoded();
//
//        //组装公钥信息
//        SubjectPublicKeyInfo publicKeyInfo;
//        if (sAlg.equals("1.2.156.197.1.301")) {
//            publicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(
//                    sAlg), publicKeyEncode);
//        } else {
//            publicKeyInfo = new SubjectPublicKeyInfo(
//                    ASN1Sequence.getInstance(publicKeyEncode));
//        }
//
//        //颁发者
//        X500Name issuer;
//        issuer = subject;
//        MessageDigest md = null;
//        try {
//            md = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        //证书序列号
//        BigInteger serial = new BigInteger(md.digest(publicKeyEncode));
//        //证书生效日期
//        Date notBefore = new Date();
//        long year = 365 * 24 * 60 * 60 * 1000;
//        //证书结束日期
//        Date notAfter = new Date(notBefore.getTime() + 10 * year);
//        //组装证书
//        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(issuer, serial, notBefore, notAfter, subject, publicKeyInfo);
//
//        //证书签名
//        ContentSigner signer = new ContentSigner() {
//
//            //TODO 签名为空
//            public byte[] getSignature() {
//                return new byte[0];
//            }
//
//            public OutputStream getOutputStream() {
//                return new ByteArrayOutputStream();
//            }
//
//            public AlgorithmIdentifier getAlgorithmIdentifier() {
//                return new AlgorithmIdentifier(X509Util.getAlgorithmOID(
//                        "SHA1withRSA").toString());
//            }
//        };
//        X509CertificateHolder certHolder = certBuilder.build(signer);
//        byte[] certBuf = null;
//        try {
//            certBuf = certHolder.getEncoded();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        CertificateFactory cf = CertificateFactory.getInstance("X509");
//        return (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(certBuf));
//    }
//}
