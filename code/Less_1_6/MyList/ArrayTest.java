package Less_1_6.MyList;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayTest {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();

        System.out.println("Закидываем 10 чисел в массив и печатаем:");
        for (int i = 0; i < 10; i++){
            myArrayList.add(ThreadLocalRandom.current().nextInt(-10, 10));
        }
        System.out.println(myArrayList);

        System.out.println("Сортируем и печатаем: ");
        myArrayList.sort();
        System.out.println(myArrayList);

        int numToAdd = 20;
        System.out.println("Добавляем число " + numToAdd + " и печатаем его индекс: ");
        myArrayList.add(numToAdd);
        System.out.println(myArrayList + " [" + myArrayList.getIndex(numToAdd) + "]");

        System.out.println("Добавляем массив {0, 1, 2} и печатаем: ");
        myArrayList.add (new int[]{0, 1, 2});
        System.out.println(myArrayList);

        System.out.println("Добавляем MyArray {3, 4, 5} и печатаем: ");
        myArrayList.add(new MyArrayList(new int[]{3, 4, 5}));
        System.out.println(myArrayList);

        int numToFind = -19;
        System.out.println("Пытаемся найти индекс элемента " + numToFind + ", которого нет: " + myArrayList.getIndex(numToFind));

        int numToCheck = ThreadLocalRandom.current().nextInt(-10, 10);
        System.out.println("Есть ли в массиве элемент " + numToCheck + ": " + myArrayList.contains(numToCheck));

        int index = 2;
        System.out.println("Печатаем элемент по индексу: [" + index + "]");
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(2));

        MyArrayList arrayListToCompare1 = new MyArrayList(new int[]{0, 1, 2});
        MyArrayList arrayListToCompare2 = new MyArrayList(new int[]{0, 1});
        arrayListToCompare2.add(2);

        System.out.println("Создаем листы {0, 1, 2} и {0, 1}, закидываем во второй массив 2 и сравниваем: " + arrayListToCompare1.equals(arrayListToCompare2));
        System.out.println("Равны ли массивы {0, 1, 2} и первосозданный: " + arrayListToCompare1.equals(myArrayList));
        System.out.println("Равны ли массивы {0, 1, 2} и {0, 1, 3}: " + new MyArrayList(new int[]{0, 1, 2}).equals(new MyArrayList(new int[]{0, 1, 3})));

        System.out.println("Очищаем и печатаем: ");
        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
