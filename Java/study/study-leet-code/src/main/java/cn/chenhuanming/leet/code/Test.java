package cn.chenhuanming.leet.code;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenhuanming
 * Created at 2018/12/27
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        Thread consumer = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(2000);
                    String value = queue.take();
                    System.out.println("consume:"+value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(()->{
            while (true){
                try {
                    queue.put("2");
                    System.out.println("put");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
