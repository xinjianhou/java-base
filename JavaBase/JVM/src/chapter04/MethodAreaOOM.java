package chapter04;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * -Xms10 -Xmx10m -XX:+PrintGcDetails
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class MethodAreaOOM extends ClassLoader{

    public static void main(String[] args) {
        int count = 0;
        MethodAreaOOM oom = new MethodAreaOOM();

        try {
            for (int i = 0; i < 100000; i++) {
                //生成Classwriter对象
                ClassWriter classWriter = new ClassWriter(0);
                //知名版本号修饰符，类名，报名，父类名，接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null,"java/lang/Object", null);
                //返回byte数组
                byte[] codes = classWriter.toByteArray();
                //加载类
                oom.defineClass("Class"+i, codes, 0, codes.length);
                count++;
            }
        } finally {
            System.out.println(count);
        }

    }
}
