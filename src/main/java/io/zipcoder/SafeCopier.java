package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) { super(toCopy);}
        ReentrantLock threadLock = new ReentrantLock();

    public void run() {

        threadLock.lock();
        while (stringIterator.hasNext()){
            try {
                this.copied += " ";
                this.copied += stringIterator.next();
            }
            catch (Exception e){
                System.out.println("Something went wrong, but error messages are good");
            }
        }

        threadLock.unlock();

    }

}
