package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private AtomicInteger counter = new AtomicInteger(1);
    private Semaphore zeroLock = new Semaphore(1);
    private Semaphore evenLock = new Semaphore(0);
    private Semaphore oddLock = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroLock.acquire();
            printNumber.accept(0);

            if (counter.get() % 2 == 0) { //even
                evenLock.release();
            } else {                      //odd
                oddLock.release();
            }
        }
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            evenLock.acquire();
            printNumber.accept(counter.get());
            incrementAndPermitZero();
        }
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            oddLock.acquire();
            printNumber.accept(counter.get());
            incrementAndPermitZero();
        }
    }

    private void incrementAndPermitZero() {
        synchronized (this) {
            counter.getAndIncrement();
            zeroLock.release();
        }
    }
}
