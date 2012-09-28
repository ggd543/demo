package jactor;


import org.agilewiki.jactor.*;

public class GettingStarted {
    public static void main(String[] args) throws Exception {

        // Create a mailbox factory with a pool of 10 threads.
        MailboxFactory mailboxFactory = JAMailboxFactory.newMailboxFactory(10);

        // Create and initialize a Test actor.
        Mailbox mailbox = mailboxFactory.createMailbox();
        Test test = new Test();
        test.initialize(mailbox);

        // Send a Start request and wait for completion.
        JAFuture future = new JAFuture();
        Start.req.send(future, test);

        // Shut down the thread pool.
        mailboxFactory.close();

    }
}

