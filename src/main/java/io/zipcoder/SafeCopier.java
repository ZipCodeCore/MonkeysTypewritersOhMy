package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    ReentrantLock threadlock = new ReentrantLock();

    public void run() {

        threadlock.lock();
        while (stringIterator.hasNext()) {
            try {
                this.copied += stringIterator.next();
                this.copied += " ";
            }
            catch (Error error) {
                System.out.println("Failed");
            }
        }
        threadlock.unlock();
    }

    public void printCopy() {
        System.out.println(this.copied);
    }
}
