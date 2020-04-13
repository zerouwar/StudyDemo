package cn.chenhuanming.study.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guangdao
 * Created at 2019-04-17
 */
public class ThreadPoolTest implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,6,10, TimeUnit.SECONDS,queue);

        for (int i = 0; i < 16; i++) {
            executor.execute(new ThreadPoolTest());
        }
    }
}
