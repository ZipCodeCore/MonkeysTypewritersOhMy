package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    ReentrantLock threadLocked = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }
    //5 monkeys waiting turns, queued up
    public void run() {
        threadLocked.lock();
        while ( stringIterator.hasNext()) {
            try {
                this.copied += stringIterator.next();
                this.copied += " ";
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadLocked.unlock();
    }
}