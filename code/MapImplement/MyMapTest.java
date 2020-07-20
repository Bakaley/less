package MapImplement;

import java.util.HashMap;

public class MyMapTest {
    public static void main(String[] args) {

        MyMap collection = new MyMap();

        System.out.println("Добавляем 3 записи");
        collection.put("google", "152.198.0.1");
        collection.put("yandex", "170.175.0.1");
        collection.put("sputnik", "175.142.0.1");
        System.out.println(collection);

        System.out.println("Ищем 2 существующую записи и 1 несущетсвующую");
        System.out.println(collection.get("google"));
        System.out.println(collection.get("yandex"));
        System.out.println(collection.get("mail.ru"));

        System.out.println("Collection значений и Set из ключей");
        System.out.println(collection.values());
        System.out.println(collection.keySet());

        System.out.println("Удаляем google");
        collection.remove("google");
        System.out.println(collection);

        System.out.println("Создаём HashMap для yahoo и bing");
        HashMap <String, String> hashMap = new HashMap<>();
        hashMap.put("yahoo", "168.125.0.1");
        hashMap.put("bing", "225.150.0.1");
        System.out.println(hashMap);

        System.out.println("и добавлем её к нашей Map");
        collection.putAll(hashMap);
        System.out.println(collection);

        System.out.println("Очищаем нашу Map");
        collection.clear();
        System.out.println(collection);
    }
}
