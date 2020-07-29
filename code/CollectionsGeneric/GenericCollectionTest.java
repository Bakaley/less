package CollectionsGeneric;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class GenericCollectionTest {

    public static void main(String[] args) {

        GenericCollection<Integer> myCollection = new GenericCollection<>();

        System.out.println(myCollection);
        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        System.out.println("Закидываем 5 чисел в массив и печатаем:");
        for (int i = 0; i < 5; i++) {
            myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myCollection);

        System.out.println("Проходимся итератором");
        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println("\t" + o);
        }

        System.out.println("Пустая ли коллекция: " + myCollection.isEmpty());

        Integer intToFind = ThreadLocalRandom.current().nextInt(-200, -150);
        System.out.print("Добавляем в коллекцию число " + intToFind + " и ищем: ");
        myCollection.add(intToFind);
        System.out.println(myCollection.contains(intToFind));
        System.out.println(myCollection);
    }

}
