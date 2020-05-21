package Zoo;

import java.awt.*;

public class Fish extends Pet{

    @Override
    public String voice(){
       return  ".....";
    }

    public Fish(){
        id = 2;
        name = "Goldy";
        age = 1.1;
        weight = 0.4;
        color = Color.YELLOW;
        isVaccinated = false;
    }
}
