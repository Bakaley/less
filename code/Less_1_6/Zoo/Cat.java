package Less_1_6.Zoo;

import java.awt.*;

public class Cat extends Pet{

    @Override
    public String voice(){
        return super.voice() + ". Meow.";
    }

    public Cat(){
        id = 6;
        name = "Barsik";
        age = 3;
        weight = 8;
        color = Color.WHITE;
        isVaccinated = true;

    }
}
