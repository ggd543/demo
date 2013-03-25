/*
 * @(#) EncoderDecoderDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-04
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class EncoderDecoderDemo {
    public static void main(String[] args) {
        String msg = "中";
        System.out.println(msg.codePointAt(0));
        System.out.println();
        System.out.println(decode("UTF-8", encode("UTF-8", msg)).toString());
        System.out.println(decode("UTF-8", encode("UTF-8", msg)).toString().codePointAt(0));
        System.out.println();
        System.out.println(decode("GBK", encode("GBK", msg)).toString());
        System.out.println(decode("GBK", encode("GBK", msg)).toString().codePointAt(0));
        System.out.println();
        System.out.println(decode("UTF-8", encode("GBK", msg)).toString());
        System.out.println(decode("UTF-8", encode("GBK", msg)).toString().codePointAt(0));
        System.out.println();
        readGBK();
        System.out.println();
        readUTF8();

    }


    private static void readGBK() {
        InputStream is = EncoderDecoderDemo.class.getResourceAsStream("/gbk.txt");
        byte[] buf = new byte[0];
        try {
            buf = new byte[is.available()];
            is.read(buf);
            System.out.println(Arrays.toString(buf));
            CharBuffer charBuffer = decode("GBK", ByteBuffer.wrap(buf));
            String gbkStr = charBuffer.toString();
            System.out.println(gbkStr);
            System.out.println(Arrays.toString(gbkStr.toCharArray()));
            System.out.println(Arrays.toString(charBuffer.array()));
            System.out.println(gbkStr.codePointAt(0));
            String utf8Str = decode("UTF-8", ByteBuffer.wrap(buf)).toString();
            System.out.println(utf8Str);
            System.out.println(utf8Str.codePointAt(0));
            // 将从gbk.txt读出来的内容，以utf-8字符编码方式写入gbk_utf8.txt
            OutputStream os = new FileOutputStream("./gbk_utf8.txt");
            os.write(gbkStr.getBytes("UTF-8"));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        }

    }

    private static void readUTF8() {
        InputStream is = EncoderDecoderDemo.class.getResourceAsStream("/utf8.txt");
        byte[] buf = new byte[0];
        try {
            buf = new byte[is.available()];
            is.read(buf);
            System.out.println(Arrays.toString(buf));
            String gbkStr = decode("GBK", ByteBuffer.wrap(buf)).toString();
            System.out.println(gbkStr);
            System.out.println(gbkStr.codePointAt(0));
            String utf8Str = decode("UTF-8", ByteBuffer.wrap(buf)).toString();
            System.out.println(utf8Str);
            System.out.println(utf8Str.codePointAt(0));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

        }
    }

    /**
     *
     */
    public static final String UTF8 = "UTF-8";
    /**
     *
     */
    public static final String GBK = "GBK";
    /**
     *
     */
    public static final String ISO8859 = "ISO8859-1";

    /**
     * @param charsetName
     * @param chars
     * @param offset
     * @param length
     * @return
     */
    public static ByteBuffer encode(
            String charsetName, char[] chars, int offset, int length) {
        return encode(charsetName, CharBuffer.wrap(chars, offset, length));
    }

    /**
     * 根据字符集<tt>charsetName</tt>,将字符缓冲区<tt>charBuffer</tt>的内容编码成字节流,然后以字节缓冲区的形式返回
     *
     * @param charsetName
     * @param charBuffer
     * @return
     */
    public static ByteBuffer encode(String charsetName, CharBuffer charBuffer) {
        try {
            CharsetEncoder charsetEncoder = getCharsetEncoder(charsetName);
            return charsetEncoder.encode(charBuffer);
        } catch (CharacterCodingException cce) {
            throw new Error(cce);
        }
    }

    /**
     * 等同于<code>CharsetUtils.encode(charsetName,CharBuffer.wrap(string)</code>
     *
     * @param charsetName
     * @param string
     * @return
     * @see {@link #encode(String, java.nio.CharBuffer)}
     */
    public static ByteBuffer encode(String charsetName, String string) {
        return encode(charsetName, CharBuffer.wrap(string));
    }

    /**
     * 获得指定的字符编码器
     *
     * @param charsetName 字符集
     * @return
     */
    public static CharsetEncoder getCharsetEncoder(String charsetName) {
        Charset charset = Charset.forName(charsetName);

        CharsetEncoder charsetEncoder = charset.newEncoder();

        charsetEncoder.onMalformedInput(CodingErrorAction.REPLACE);
        charsetEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);

        return charsetEncoder;
    }

    public static CharBuffer decode(String charsetName, byte[] bytes) {
        return decode(charsetName, ByteBuffer.wrap(bytes));
    }

    public static CharBuffer decode(String charsetName, byte[] bytes, int offset, int length) {
        return decode(charsetName, ByteBuffer.wrap(bytes, offset, length));
    }

    public static CharBuffer decode(String charsetName, ByteBuffer byteBuffer) {
        try {
            CharsetDecoder charsetDecoder = getCharsetDecoder(charsetName);
            return charsetDecoder.decode(byteBuffer);
        } catch (CharacterCodingException cce) {
            throw new Error(cce);
        }
    }

    public static CharsetDecoder getCharsetDecoder(String charsetName) {
        Charset charset = Charset.forName(charsetName);

        CharsetDecoder charsetDecoder = charset.newDecoder();

        charsetDecoder.onMalformedInput(CodingErrorAction.REPLACE);
        charsetDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);

        return charsetDecoder;
    }
}
