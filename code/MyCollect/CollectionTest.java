package MyCollect;

import java.util.concurrent.ThreadLocalRandom;

public class CollectionTest {

    public static void main(String[] args) {

        MyCollection myCollection = new MyCollection();

        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        System.out.println("Закидываем 5 чисел в массив и печатаем:");
        for (int i = 0; i < 5; i++){
            myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myCollection);

        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());


        Integer intToFind =  ThreadLocalRandom.current().nextInt(-200, -150);
        System.out.print("Добавляем в коллекцию число " + intToFind + " и ищем: ");
        myCollection.add(intToFind);
        System.out.println(myCollection.contains(intToFind));
        System.out.println(myCollection);


        System.out.println("Добавляем строку и удаляем её");
        myCollection.add("Delete me");
        System.out.println(myCollection);
        myCollection.remove("Delete me");
        System.out.println(myCollection);

        MyCollection collectionToRetain = new MyCollection();

        for (int i = 0; i < 5; i++){
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        collectionToRetain.add("Retain me");
        myCollection.add("Retain me");
        System.out.println("Сохраняем общие элементы коллекций " + myCollection + " и " + collectionToRetain + " в первой:");
        myCollection.retain(collectionToRetain);
        System.out.println(myCollection);

        myCollection.clear();
        collectionToRetain.clear();
        for (int i = 0; i < 10; i++){
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-5, 5));
            myCollection.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        System.out.println("Удаляем общие элементы коллекций " + myCollection + " и " + collectionToRetain + " из первой:");
        myCollection.remove(collectionToRetain);
        System.out.println(myCollection);

        collectionToRetain.clear();
        for (int i = 0; i < 5; i++){
            collectionToRetain.add(ThreadLocalRandom.current().nextInt(-5, 5));
        }

        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.contains(collectionToRetain));
        myCollection.add(collectionToRetain);
        System.out.println("Содержит ли коллекция " + myCollection + " все элементы из коллекции " + collectionToRetain + ": " + myCollection.contains(collectionToRetain));



    }
}
