package CollectionImplement;

import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {

    //каждое изменение коллекции IntegerCollectionImplement вызывает sort(), реализованы только методы add и remove
    //метод contains в IntegerCollectionImplement был переписан под бинарный поиск (для интов)

    public static void main(String[] args) {

        IntegerCollectionImplement myCollection = new IntegerCollectionImplement();

        System.out.println(myCollection);
        System.out.println("Закидываем 15 чисел в массив и печатаем:");
        for (int i = 0; i < 15; i++) {
            myCollection.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myCollection);

        myCollection.add(15);
        System.out.println(myCollection.contains(-4));
        System.out.println(myCollection.contains(8));
        System.out.println(myCollection.contains(15));

    }
}
