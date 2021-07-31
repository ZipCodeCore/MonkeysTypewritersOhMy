package io.zipcoder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    ReentrantLock lock = new ReentrantLock();

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        lock.lock();
        while(this.stringIterator.hasNext()){
            try{
                this.copied += stringIterator.next();
                this.copied += " ";
            } catch (Exception error){
                error.printStackTrace();
                System.out.println("Oh no! Something went wrong!");
            }
        }
        lock.unlock();
    }

    public void printCopy(){
        System.out.println(this.copied);
    }
}
