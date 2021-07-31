package io.zipcoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    public SafeCopier(String toCopy){
        super(toCopy);
    }
    //winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
    ReentrantLock threadlock = new ReentrantLock();

    @Override
    public void run() {

        Thread current = Thread.currentThread();
        threadlock.lock();
        while(stringIterator.hasNext()){
            try {
                this.copied += " ";
                this.copied += stringIterator.next();
            }
            catch(Exception e){
                System.out.println("Something went wrong, but error messages are gross");
            }
        }
        threadlock.unlock();
    }

    public void printCopy(){
        System.out.println(this.copied);
    }

}
