package cn.chenhuanming.encryption;

/**
 * @author guangdao
 * Created at 2020-03-16
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        new Thread(a).start();
        Thread.sleep(3000);
        a.b = 2;
        //阻塞住主线程
        while (true){}
    }

    static class A implements Runnable{

        public Integer b = 1;

        @Override
        public void run() {
            while (b==1){
                synchronized(this){
                }
            }

            System.out.println("A is finished!");
        }
    }
}
