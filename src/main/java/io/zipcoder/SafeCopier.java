package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    ReentrantLock threadlock = new ReentrantLock();

    public void run() {

        threadlock.lock();
        while (stringIterator.hasNext()) {
            try {
                this.copied += " ";
                this.copied += stringIterator.next();
            } catch (Exception e) {
                System.out.println("An error has broken loose");
            }
        }
        threadlock.unlock();
    }

}
