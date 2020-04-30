import java.util.LinkedHashMap;
import java.util.concurrent.Semaphore;

public class synchronizedTest {
    private boolean numDone = false;
    //private boolean second;
    private Object lock = new Object();
    private Semaphore semaphoreInt = new Semaphore(1);
    private Semaphore semaphoreChar = new Semaphore(0);
    private int n;

    public synchronizedTest(int n) {
        this.n = n;
    }

    public void first() throws InterruptedException {
            for (int i=1;i<=n;i++){
                synchronized(lock){
                    if (numDone) lock.wait();
                    System.out.print(i);//printFirst.run();
                    numDone = true;
                    lock.notifyAll();
                }
            }



        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second() throws InterruptedException {
        for (int i=0;i<n;i++){
            synchronized (lock){
                if (!numDone) lock.wait();
                char out;
                if(i<26) out = (char)(i + 'a');
                else out = (char)(i-26+'A');
                System.out.print(out);//printSecond.run();
                numDone = false;
                lock.notifyAll();
            }
        }
        class test extends LinkedHashMap<Integer,Integer> {
            public test(){
                super(100,.75f,true);
            }
        }


        // printSecond.run() outputs "second". Do not change or remove this line.

    }


    public static void main(String[] args) {
        synchronizedTest foo = new synchronizedTest(50);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t2.start();
        t1.start();
    }
}

