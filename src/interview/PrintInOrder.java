package interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintInOrder {

    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.println("One");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.println("Two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.println("Three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
        t3.start();
    }

    static class Foo {
        public Semaphore seam_first_two = new Semaphore(0);

        public Semaphore seam_two_second = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            seam_first_two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            seam_first_two.acquire();
            printSecond.run();
            seam_two_second.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            seam_two_second.acquire();
            printThird.run();
        }
    }

    class Foo1 {
        private CountDownLatch second = new CountDownLatch(1);
        private CountDownLatch third = new CountDownLatch(1);

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
