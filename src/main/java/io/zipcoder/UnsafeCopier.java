package io.zipcoder;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {
    //5 monkeys doing monkey business
    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        while ( stringIterator.hasNext()) {
            this.copied += stringIterator.next();
            this.copied += " "; //add space because we split it at space.
        }
    }
}
