import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {

    /**
     * 屏障用于达到指定线程数时放行
     */
    private final CyclicBarrier barrier;

    /**
     * 信号量用于控制每种类型线程在单次循环时的数目
     */
    private final Semaphore hs;
    private final Semaphore os;

    public H2O() {
        barrier = new CyclicBarrier(3);
        hs = new Semaphore(2);
        os = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hs.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        os.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        os.release();
    }

    public static void main(String[] args) {
        H2O h2o = new H2O();
        String input = "OOHHHH";
        for (char c : input.toCharArray()) {
            if (c == 'H') new Thread(() -> {
                try {
                    h2o.hydrogen(() -> System.out.print(c));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            if (c == 'O') new Thread(() -> {
                try {
                    h2o.oxygen(() -> System.out.print(c));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}