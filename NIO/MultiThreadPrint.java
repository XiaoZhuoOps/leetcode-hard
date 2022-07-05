package NIO;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadPrint {

    //    =============================== 方案1 ===============================
    private static final Object lock = new Object();
    private static int counter = 0;

    private void print1(int num, String msg) throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                while (counter % 3 != num) {
                    lock.wait();
                }
                System.out.println(num + "/" + msg + "/" + counter);
                counter++;
                lock.notifyAll();
            }
        }
    }

    //    =============================== 方案2 ===============================
    private static final Lock reentrantLock = new ReentrantLock();
    private static final Condition c1 = reentrantLock.newCondition();
    private static final Condition c2 = reentrantLock.newCondition();
    private static final Condition c3 = reentrantLock.newCondition();

    private void print2(String msg, Condition c1, Condition c2) throws InterruptedException {
        reentrantLock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "/" + msg);
                c2.signal();
                c1.await();
            }
        } catch (Exception e) {
            System.out.println("something is wrong!");
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                new MultiThreadPrint().print1(0, "0");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new MultiThreadPrint().print1(1, "1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                new MultiThreadPrint().print1(2, "2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HashMap
            ConcurrentHashMap
        }).start();
    }
}
