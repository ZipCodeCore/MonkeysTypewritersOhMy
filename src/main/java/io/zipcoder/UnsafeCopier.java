package io.zipcoder;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {

        String consolidatedString = super.copied;
        for (Iterator<String> itr = super.stringIterator; itr.hasNext(); ) {

            String stringReceived = itr.next();
            consolidatedString = consolidatedString + " " + stringReceived;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.copied = consolidatedString;
    }
}
