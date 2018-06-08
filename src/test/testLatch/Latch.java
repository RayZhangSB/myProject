package testLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CountLatchDown
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/6/7 20:33
 * @Version 1.0
 **/
public class Latch {

    private static final Logger logger = LoggerFactory.getLogger(Latch.class);
    public Latch(){
        System.out.println("父类构造器");
    }
    static {
        System.out.println("父 static 块");
    }
    public  void maiddn() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        CyclicBarrier c = new CyclicBarrier(10);
        for (int i = 0; i <10 ; i++) {
            executorService.execute(new testT(latch,"thread"+i));

        }

        latch.await();
    }

    public static void main(String[] args) throws InterruptedException {
            new ff();
    }








    class  testT implements Runnable{
        private CountDownLatch latch;
        private String name;
        public testT(CountDownLatch latch,String name){
            this.name = name;
            this.latch = latch;
        }

        public void run() {
            System.out.println("preparing"+"----------------->"+name);

            try {
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("start"+"----------------->"+name);

        }
    }



}

class ff extends Latch{

    static int kk=123;

    public ff(){
        System.out.println("子类构造器");
    }

    static {
        System.out.println("子类块");
    }


}