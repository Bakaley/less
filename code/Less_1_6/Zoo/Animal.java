package Less_1_6.Zoo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Animal {

    protected int id;

    protected double age;
    protected double weight;
    protected Color color;



    public String voice (){
        return "Hello,";
    }

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Fish());
        animals.add(new Hamster());
        animals.add(new Lion());
        animals.add(new Giraffe());
        animals.add(new Guide_Dog());

        Iterator iterator = animals.iterator();
        Animal animal;
        while (iterator.hasNext()){
            animal = (Animal)iterator.next();
            System.out.println(animal.getClass().getName() + ": " + animal.voice());
        }
    }
}
