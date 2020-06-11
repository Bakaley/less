package IteratorImplementations;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListIteratorTest {
    public static void main(String[] args) {

        LinkedListIterable myCollection = new LinkedListIterable();

        System.out.println("Закидываем 5 чисел в массив и печатаем:");
        for (int i = 0; i < 5; i++) {
            myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myCollection);

        Iterator iterator = myCollection.iterator();

        System.out.println("Проходим итератором по односвязному листу: ");
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println("\t" + o);
        }
    }
}
