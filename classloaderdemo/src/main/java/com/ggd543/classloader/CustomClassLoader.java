package com.ggd543.classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Created by ggd543 on 14-1-6.
 */
public class CustomClassLoader extends ClassLoader {


    @Override
    protected synchronized Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream is = null;
        Class clazz =  null;
        try {
            is = new FileInputStream("F:\\workspace\\git\\demo\\classloaderdemo\\src\\main\\Hello.class");
            byte[] classBuffer = new byte[is.available()];
            is.read(classBuffer);
            System.out.println(name);
            clazz =  super.defineClass(name, classBuffer, 0, classBuffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clazz;
    }
}
