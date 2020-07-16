package BinaryTreeImplement;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class MyBinaryTreeTest {

    static MyBinaryTree collection;
    static ArrayList collectionToRetain;
    static int sizeOfRegenaration = 5;

    @Before
    public void setUp(){
        collection = new MyBinaryTree();
        collectionToRetain = new ArrayList();
    }

    //стереть и закинуть 5 элементов в коллекцию
    public static void regenerate (Collection c){
        c.clear();
        for (int i = 0; i < sizeOfRegenaration; i++) {
            int integer = ThreadLocalRandom.current().nextInt(-10, 10);
            while (c.contains(integer)) integer = ThreadLocalRandom.current().nextInt(-10, 10);
            c.add(integer);
        }
    }

    //стереть обе и закинуть 5 одинаковых элементов в обе
    public static void equallyRegenerate (){
        collection.clear();
        collectionToRetain.clear();
        for (int i = 0; i < sizeOfRegenaration; i++) {
            int integer = ThreadLocalRandom.current().nextInt(-10, 10);
            while (collection.contains(integer)) integer = ThreadLocalRandom.current().nextInt(-10, 10);
            collection.add(integer);
            collectionToRetain.add(integer);
        }
    }

    @Test
    public void size() {
        assertEquals(0, collection.size());
        regenerate(collection);
        assertEquals(sizeOfRegenaration, collection.size());
        collection.clear();
        assertEquals(0, collection.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(true, collection.isEmpty());
        regenerate(collection);
        assertEquals(false, collection.isEmpty());
        collection.clear();
        assertEquals(true, collection.isEmpty());
    }

    @Test
    public void contains() {
        Integer intToFind = ThreadLocalRandom.current().nextInt(-200, -150);

        assertEquals(false, collection.contains(intToFind));
        regenerate(collection);
        assertEquals(false, collection.contains(intToFind));
        collection.add(intToFind);
        assertEquals(true, collection.contains(intToFind));
        collection.clear();
        assertEquals(false, collection.contains(intToFind));
    }

    @Test
    public void toArray() {
        assertEquals(collection.size(), collection.toArray().length);
        regenerate(collection);
        assertEquals(collection.size(), collection.toArray().length);
        collection.clear();
        assertEquals(collection.size(), collection.toArray().length);
    }

    @Test
    public void add() {
        Integer intToAdd = ThreadLocalRandom.current().nextInt(-200, -150);

        assertEquals(false, collection.contains(intToAdd));
        assertEquals(0, collection.size());
        collection.add(intToAdd);
        assertEquals(true, collection.contains(intToAdd));
        assertEquals(1, collection.size());
    }

    @Test
    public void remove() {
        Integer intToRemove = ThreadLocalRandom.current().nextInt(-200, -150);

        collection.add(1);
        collection.add(-22);
        collection.add(35);
        collection.add(4);
        collection.add(15);
        collection.add(-8);
        collection.add(40);


        collection.remove(1);
        System.out.println(collection);
        collection.remove(40);
        System.out.println(collection);
        collection.remove(15);
        System.out.println(collection);
        collection.remove(4);
        System.out.println(collection);
        collection.remove(35);
        System.out.println(collection);
        collection.remove(-8);
        System.out.println(collection);
        collection.remove(-22);
        System.out.println(collection);


        collection.remove(6);






        assertEquals(0, collection.size());
        regenerate(collection);
        collection.add(intToRemove);
        assertEquals(sizeOfRegenaration + 1, collection.size());
        assertEquals(true, collection.contains(intToRemove));
        collection.remove(intToRemove);
        assertEquals(false, collection.contains(intToRemove));
        assertEquals(sizeOfRegenaration, collection.size());


    }

    @Test
    public void containsAll() {
        assertEquals(true, collection.containsAll(collectionToRetain));
        regenerate(collectionToRetain);
        assertEquals(false, collection.containsAll(collectionToRetain));
        equallyRegenerate();
        assertEquals(true, collection.containsAll(collectionToRetain));
        collection.clear();
        collectionToRetain.clear();
        assertEquals(true, collection.containsAll(collectionToRetain));

    }

    @Test
    public void addAll() {
        collection.addAll(collectionToRetain);
        assertEquals(0, collection.size());
        regenerate(collectionToRetain);
        collection.addAll(collectionToRetain);
        assertEquals(sizeOfRegenaration, collection.size());
    }

    @Test
    public void removeAll() {
        regenerate(collection);
        collection.removeAll(collectionToRetain);
        assertEquals(sizeOfRegenaration, collection.size());
        equallyRegenerate();

        System.out.println(collection);
        System.out.println(collectionToRetain);

        collection.removeAll(collectionToRetain);
        assertEquals(0, collection.size());
        System.out.println(collectionToRetain);
    }

    @Test
    public void retainAll() {
        collection.retainAll(collectionToRetain);
        assertEquals(0, collection.size());
        equallyRegenerate();
        collection.retainAll(collectionToRetain);
        assertEquals(sizeOfRegenaration, collection.size());
        equallyRegenerate();
        collection.add(ThreadLocalRandom.current().nextInt(-1000, -950));
        collection.add(ThreadLocalRandom.current().nextInt(-940, -900));
        collectionToRetain.add(ThreadLocalRandom.current().nextInt(-1200, -1150));
        collection.retainAll(collectionToRetain);
        assertEquals(sizeOfRegenaration, collection.size());

    }

    @Test
    public void clear() {
        collection.clear();
        assertEquals(0, collection.size());
        regenerate(collection);
        collection.clear();
        assertEquals(0, collection.size());
    }

}