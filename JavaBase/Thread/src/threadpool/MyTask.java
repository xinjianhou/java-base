package threadpool;

import java.io.*;
import java.util.List;

public class MyTask implements Runnable {
    private String name;

    private List<String> text;

    private int len;

    public MyTask(String name, List<String> text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        BufferedOutputStream os = null;
        // 1K的数据缓冲
       // byte[] bs = new byte[102400];

        try {
            os = new BufferedOutputStream(
                    new FileOutputStream(this.name));
            for (String t : text) {

                os.write(t.getBytes());

            }
            os.flush();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println(Thread.currentThread().getName() + ":" + name);

    }

}

