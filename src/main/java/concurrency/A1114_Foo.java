package concurrency;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class A1114_Foo {

    // 15ms
    class Foo_LongAdder {

        LongAdder la = new LongAdder();

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            la.add(1);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            long cur = la.longValue();
            while(cur != 1){
                cur = la.longValue();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            la.add(1);
        }

        public void third(Runnable printThird) throws InterruptedException {
            long cur = la.longValue();
            while(cur != 2){
                cur = la.longValue();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }


    // 15ms
    class Foo_AtomicInteger {

        AtomicInteger integer = new AtomicInteger();

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            integer.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while(integer.get() != 1){

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            integer.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while(integer.get() != 2){

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
