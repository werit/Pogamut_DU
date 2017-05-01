package cz.cuni.amis.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class allows you to combine several iterators in the single one allowing
 * you to seamlessly iterate over several collections at once.
 * <p>
 * <p>
 * This class behaves as defined by {@link Iterator} contract.
 *
 * @author Jimmy
 *
 * @param <NODE>
 */
public class Iterators<NODE> implements Iterator<NODE> {

    private List<Iterator<NODE>> iterList;
    private Iterator<NODE> currIter;
    private int counter;

    /**
     * Initialize this class to use "iterators" in the order as they are passed
     * into the constructor.
     *
     * @param iterators may contain nulls
     */
    public Iterators(Iterator<NODE>... iterators) {
        this.iterList = new ArrayList<Iterator<NODE>>();
        // fill up iterator container
        for (int i = 0; i < iterators.length; i++) {
//            if (iterators[i] == null) {
//                continue;
//            }
            iterList.add(iterators[i]);
        }

        this.counter = 0;
        this.currIter = null;
        if (iterList.size() > 0) {
            this.currIter = iterList.get(counter);
        }
    }

    @Override
    public boolean hasNext() {
        // TODO: implement me!
        boolean returnValue = false;
        if (currIter != null) {
            if (!currIter.hasNext()) {
                if (iterList.size() > this.counter + 1) {
                    Iterator<NODE> tmpIter = currIter;
                    counter += 1;
                    currIter = iterList.get(counter);
                    returnValue = hasNext();
                    counter -= 1;
                    currIter = tmpIter;
                } else {
                    returnValue = false;
                }
            } else {
                returnValue = true;
            }
        } else {// curriter == null
            if (iterList.size() > this.counter + 1) {
                Iterator<NODE> tmpIter = currIter;
                counter += 1;
                currIter = iterList.get(counter);
                returnValue = hasNext();
                counter -= 1;
                currIter = tmpIter;
            }
            // default return false;
        }
        return returnValue;
    }

    @Override
    public NODE next() {
        // TODO: implement me!
        if (!hasNext()) {
            // necham ho vyhodit rovnaku exception ako normalny next pri null
            if (currIter == null) {
                throw new NoSuchElementException();
            }
            return currIter.next();
        } else {
            if (currIter != null && currIter.hasNext()) {
                return currIter.next();

            } else {
                // try next iterator in line
                if (iterList.size() > this.counter + 1) {
                    counter += 1;
                    currIter = iterList.get(counter);
                    return next();
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public void remove() {
        // TODO: implement me!
        if (currIter == null) {
            if (iterList.size() > this.counter + 1) {
                counter += 1;
                currIter = iterList.get(counter);
                remove();
            }
        }
        if (currIter == null) {
            throw new IllegalStateException();
        }
        currIter.remove();
    }

}
