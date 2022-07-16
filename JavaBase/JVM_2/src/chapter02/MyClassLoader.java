package chapter02;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String className = this.path + File.separator + name + ".class";

        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(className));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byte[] bytecode = byteArrayOutputStream.toByteArray();

            clazz = super.defineClass(null, bytecode, 0, bytecode.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != bufferedInputStream)
                    bufferedInputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (null != byteArrayOutputStream)
                    byteArrayOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return clazz;
    }
}
