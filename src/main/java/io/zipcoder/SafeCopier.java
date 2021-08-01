package io.zipcoder;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    public SafeCopier(String toCopy) {super(toCopy); }

    @Override
    public synchronized void run() {
        while(stringIterator.hasNext()){
            try {
                this.copied += stringIterator.next();
                this.copied += " ";
            }
            catch(Exception e) {
                System.out.println("Oh no! Something went wrong. Here, have an error message.");
            }
        }
    }

    public void printCopy() {
        System.out.println(this.copied);
    }
}
