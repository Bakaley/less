package BinaryTreeImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryTreeTest {
    public static void main(String[] args) {

        MyBinaryTree myCollection = new MyBinaryTree();

        System.out.println(myCollection);
        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        System.out.println("Закидываем 5 чисел в массив и печатаем:");
        for (int i = 0; i < 5; i++) {
            myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myCollection);

        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        Integer intToFind = ThreadLocalRandom.current().nextInt(-200, -150);
        System.out.print("Добавляем в коллекцию число " + intToFind + " и ищем: ");
        myCollection.add(intToFind);
        System.out.println(myCollection.contains(intToFind));
        System.out.println(myCollection);

        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()){
            Integer node = (Integer) iterator.next();
            System.out.println(node);
        }

        System.out.println("Добавляем и удаляем 185");
        myCollection.add(185);
        System.out.println(myCollection);
        myCollection.remove(185);
        System.out.println(myCollection);

        System.out.println("Взаимодействия с ArrayList (в квадратных скобках):");
        ArrayList<Object> collectionToRetain = new ArrayList<>();

        collectionToRetain.add(250);
        collectionToRetain.add(185);
        myCollection.add(250);
        myCollection.add(185);
        System.out.println("Удалить все элементы коллекции " + collectionToRetain + " из коллекции " + myCollection);
        myCollection.removeAll(collectionToRetain);
        System.out.println(myCollection);

        myCollection.clear();
        collectionToRetain.clear();
        for (int i = 0; i < 10; i++) {
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-5, 5));
            myCollection.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        System.out.println("Удаляем общие элементы коллекций " + myCollection + " и " + collectionToRetain + " из первой:");
        myCollection.removeAll(collectionToRetain);
        System.out.println(myCollection);


        for (int i = 0; i < 5; i++) {
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.containsAll(collectionToRetain));
        myCollection.addAll(collectionToRetain);
        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.containsAll(collectionToRetain));

    }
}
