package MyLinkedListImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedListTest{

    public static void main(String[] args) {


    MyLinkedList myCollection = new MyLinkedList();

        System.out.println(myCollection);
        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        System.out.println("Закидываем 5 чисел в массив и печатаем:");
           for (int i = 0; i < 5; i++){
           myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
           }

        System.out.println(myCollection);
        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        Integer intToFind =  ThreadLocalRandom.current().nextInt(-200, -150);
        System.out.println("Ищем " + intToFind + " не добавляя в коллецию:");
        System.out.println(myCollection.contains(intToFind));
        System.out.print("Добавляем в коллекцию число " + intToFind + " и ищем: ");
        myCollection.add(intToFind);
        System.out.println(myCollection.contains(intToFind));
        System.out.println(myCollection);

        Object[] array = myCollection.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        System.out.println("Делаем pop() 3 раза:" );
        for (int i = 0; i < 3; i++) {
            System.out.println("\t До pop() " + myCollection);
            System.out.println("\t pop() " + myCollection.pop());
            System.out.println("\t После pop() " + myCollection);
            System.out.println("");
        }

        System.out.println("");
        System.out.println("-------------------------------------------------");
        System.out.println("");
        System.out.println("Взаимодействия с ArrayList (в квадратных скобках):");
        ArrayList<Object> collectionToRetain = new ArrayList<>();

        myCollection.clear();
        collectionToRetain.clear();
        for (int i = 0; i < 10; i++) {
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-5, 5));
            myCollection.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        collectionToRetain.clear();
        for (int i = 0; i < 5; i++) {
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.containsAll(collectionToRetain));
        myCollection.addAll(collectionToRetain);
        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.containsAll(collectionToRetain));

    }


}
