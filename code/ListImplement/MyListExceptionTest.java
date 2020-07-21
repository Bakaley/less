package ListImplement;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class MyListExceptionTest {

    static MyList collection;
    static ArrayList collectionToRetain;

    @Before
    public void setUp(){
        collection = new MyList();
        collectionToRetain = new ArrayList();
    }

    @Test (expected = NullPointerException.class)
    public void addAll() {
        collectionToRetain = null;
        collection.addAll(collectionToRetain);
    }

    @Test (expected = NullPointerException.class)
    public void addAll1() {
        collectionToRetain = null;
        collection.addAll(5, collectionToRetain);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addAll2() {
        collection.addAll(5, collectionToRetain);
    }

    @Test (expected = NullPointerException.class)
    public void removeAll() {
        collectionToRetain = null;
        collection.removeAll(collectionToRetain);
    }

    @Test (expected = NullPointerException.class)
    public void retainAll() {
        collectionToRetain = null;
        collection.retainAll(collectionToRetain);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void set() {
        collection.set(-4, 5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void set1() {
        collection.set(245, 5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void subList() {
        collection.subList(-4, 5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void subList1() {
        collection.subList(5, 0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void subList2() {
        collection.subList(0, -4);
    }
}