package chapter02;


public class ClassLoaderTest {
    public static void main(String[] args) {

        //获取系统加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        System.out.println(loader);

        //获取上层扩展类加载器
        ClassLoader extClassLoader = loader.getParent();
        System.out.println(extClassLoader);

        //获取上层引导类加载器, 获取不到
        ClassLoader bootstrap = extClassLoader.getParent();
        System.out.println(bootstrap);//null


        //自定义类的加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //也是用引导类加载器加载的 --> java核心类库都是用引导类加载器加载的
        ClassLoader loader1 = String.class.getClassLoader();
        System.out.println(loader1);//null
    }
}
