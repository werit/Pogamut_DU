package cz.cuni.amis.utils.lazy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utility class for lazy initialization of objects.
 * <p>
 * <p>
 * {@link #create(Object)} is called in THREAD-SAFE manner, we guarantee to call
 * it only once.
 */
public abstract class Lazy<T> {

    /**
     * Creates lazy initialized object.
     *
     * @return
     */
    private AtomicInteger ai = new AtomicInteger(0);
    private boolean isInicialized = false;
    private T obj = null;

    abstract protected T create();

    /**
     * Synonym for {@link Lazy#getVal()}.
     *
     * @return
     */
    public T get() {
        // TODO: implement me!

//        while (ai.addAndGet(1) != 1) {
//            ai.decrementAndGet();
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                System.err.println("InterruptedException in Lazy method.");
//            }
//        }
        synchronized (ai) {
            if (!isInicialized) {
                isInicialized = true;
                obj = this.create();
            }
        }
//        ai.decrementAndGet();
//        notifyAll();
        return obj;
    }

}
