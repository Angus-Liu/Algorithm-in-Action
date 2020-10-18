import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private AtomicInteger num = new AtomicInteger(1);
    private CyclicBarrier barrier = new CyclicBarrier(4, () -> num.getAndIncrement());

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num.get() <= n) {
            if (num.get() % 3 == 0 && num.get() % 5 != 0)
                printFizz.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num.get() <= n) {
            if (num.get() % 3 != 0 && num.get() % 5 == 0)
                printBuzz.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num.get() <= n) {
            if (num.get() % 3 == 0 && num.get() % 5 == 0)
                printFizzBuzz.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num.get() <= n) {
            if (num.get() % 3 != 0 && num.get() % 5 != 0)
                printNumber.accept(num.get());
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.number(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}