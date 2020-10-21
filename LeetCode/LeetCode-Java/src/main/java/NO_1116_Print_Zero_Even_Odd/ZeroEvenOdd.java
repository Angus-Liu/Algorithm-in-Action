package NO_1116_Print_Zero_Even_Odd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    private volatile int i = 1;
    private Semaphore z = new Semaphore(1);
    private Semaphore e = new Semaphore(0);
    private Semaphore o = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            z.acquire();
            if (i > n) break;
            printNumber.accept(0);
            if (i % 2 == 0)
                e.release();
            else
                o.release();
        }
        z.release();
        e.release();
        o.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            e.acquire();
            if (i > n) return;
            printNumber.accept(i++);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            o.acquire();
            if (i > n) return;
            printNumber.accept(i++);
            z.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(5);

        new Thread(() -> {
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeo.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}