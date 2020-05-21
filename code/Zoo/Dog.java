package Zoo;

import java.awt.*;

public class Dog extends Pet {

    @Override
    public String voice(){
        return super.voice() + ". Woof.";
    }

    public Dog(){
        id = 1;
        name = "Lancy";
        age = 3;
        weight = 8;
        color = Color.BLACK;
        isVaccinated = true;

    }
}
