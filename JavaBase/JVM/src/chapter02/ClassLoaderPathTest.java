package chapter02;

import com.sun.net.ssl.internal.ssl.Provider;
import sun.misc.Launcher;

import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;

//获取引导类加载器的加载jar目录
public class ClassLoaderPathTest {

    public static void main(String[] args) {
        System.out.println("=======引导类加载器======");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("=======扩展类加载器======");
        //String property = System.getProperty("java.ext.dirs");

        String var0 = System.getProperty("java.ext.dirs");
        File[] var1;
        if (var0 != null) {
            StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
            int var3 = var2.countTokens();
            var1 = new File[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
                var1[var4] = new File(var2.nextToken());
            }
        } else {
            var1 = new File[0];
        }


        for (File s : var1) {
            System.out.println(s.getPath());

        }

    }
}

