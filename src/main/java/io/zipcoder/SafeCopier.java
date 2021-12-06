package io.zipcoder;

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    ReentrantLock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {

        for (Iterator<String> itr = super.stringIterator; itr.hasNext(); ) {
            lock.lock();
            String stringReceived = itr.next();
            System.out.println(Thread.currentThread().getName() + " received text: " + stringReceived);
            super.copied = super.copied.concat(" ").concat(stringReceived);
            lock.unlock();
        }
    }
}
